package com.da17.my_pet_health.controller;

import com.da17.my_pet_health.dto.AIMessage;
import com.da17.my_pet_health.entity.Chat;
import com.da17.my_pet_health.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dich-vu")
@Slf4j
public class ServiceController {

    @GetMapping
    public String getService(Model model) {
        return "service/service";
    }

    @GetMapping("/chuan-doan-benh")
    public String getDiagnosis(Model model) {
        List<Chat> chatHistory = List.of(
                Chat.builder().userName("Buddy").unreadCount(5).build(),
                Chat.builder().userName("Mittens").unreadCount(4).build()
        );
        model.addAttribute("chatHistory", chatHistory);

        List<Message> messages = List.of(
            Message.builder().content("user send message").build(),
            AIMessage.builder().content("ai response message").aiModelName("gemini").build(),
            Message.builder().content("user send another message").build(),
            AIMessage.builder().content("ai response another message").aiModelName("gemini").build()
        );

        Chat activeChat = Chat.builder().messages(messages).build();
        model.addAttribute("activeChat", activeChat);
        return "service/diagnosis/diagnosis";
    }
}
