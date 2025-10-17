package com.da17.my_pet_health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {

    @GetMapping("/dich-vu")
    public String getService(Model model) {
        return "service/service";
    }
}
