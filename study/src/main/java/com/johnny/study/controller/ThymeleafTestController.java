package com.johnny.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafTestController {

    @GetMapping("/thymeleafTest")
    public String hello(Model model) {
        model.addAttribute("name", "Hello, This is Thymeleaf test page !!!");
        return "thymeleafTest";
    }
}
