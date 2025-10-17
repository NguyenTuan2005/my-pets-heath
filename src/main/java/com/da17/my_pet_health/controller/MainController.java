package com.da17.my_pet_health.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Spring Boot!");
        return "index";
    }
}
