package com.da17.my_pet_health.service;

import com.da17.my_pet_health.entity.Message;
import com.da17.my_pet_health.enums.MessageType;
import com.da17.my_pet_health.request.MessageRequest;
import com.da17.my_pet_health.response.MessageResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {
    @Value("${colab_url}")
    private String COLAB_URL;

    public ResponseEntity<?> sendMessageToColab(MessageRequest messageRequest) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> body = new HashMap<>();
        body.put("message", messageRequest.getMessageContent());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    COLAB_URL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

            String responseBody = response.getBody();

            if (response.getHeaders().getContentType() != null &&
                    response.getHeaders().getContentType().includes(MediaType.APPLICATION_JSON)) {

                // Parse JSON manually or use ObjectMapper
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> jsonResponse = objectMapper.readValue(responseBody, Map.class);

                if (jsonResponse.containsKey("response")) {
                    Message message = Message.builder()
                            .content(jsonResponse.get("response").toString())
                            .type(MessageType.isResponse)
                            .build();

                    MessageResponse messageResponse = MessageResponse.builder()
                            .success(true)
                            .message(message)
                            .timestamp(message.getUpdateAtAsLocalDateTime())
                            .build();
                    return ResponseEntity.ok(messageResponse);
                }
            }

            // If not JSON, return error with actual response for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unexpected response format from Colab server: " + responseBody);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error communicating with Colab server: " + e.getMessage());
        }
    }
}
