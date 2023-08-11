package com.example.p2b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/mainpage")
    public String mainpage(){
        return "P2F/index";
    }
}