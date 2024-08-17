package com.example.homework14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/test-thymeleaf")
    public String test() {
        return "test";
    }
}
