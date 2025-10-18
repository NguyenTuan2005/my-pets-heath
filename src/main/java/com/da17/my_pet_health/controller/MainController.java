package com.da17.my_pet_health.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Home Page!");
        return "about/about-intro";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("message", "Welcome to the Home Page!");
        return "about/about-intro";
    }
}
