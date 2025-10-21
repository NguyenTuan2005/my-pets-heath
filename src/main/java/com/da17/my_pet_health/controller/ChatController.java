package com.da17.my_pet_health.controller;

import com.da17.my_pet_health.request.MessageRequest;
import com.da17.my_pet_health.service.ChatService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody MessageRequest messageRequest,
                                         HttpServletRequest request) {
        return chatService.sendMessageToColab(messageRequest);
    }
}