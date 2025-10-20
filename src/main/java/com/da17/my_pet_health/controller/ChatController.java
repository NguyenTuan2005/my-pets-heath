package com.da17.my_pet_health.controller;

import com.da17.my_pet_health.entity.Message;
import com.da17.my_pet_health.enums.MessageType;
import com.da17.my_pet_health.request.MessageRequest;
import com.da17.my_pet_health.response.MessageResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody MessageRequest messageRequest,
                                         HttpServletRequest request) {
//      return chatSerivce.saveMessage(messageRequeset);
        Message message = Message.builder().content("ai response message").type(MessageType.isResponse).build(); //temp

        MessageResponse messageResponse = MessageResponse.builder()
                .success(true)
                .message(message)
                .timestamp(message.getUpdateAtAsLocalDateTime())
                .build();
        return ResponseEntity.ok(messageResponse);
    }
}