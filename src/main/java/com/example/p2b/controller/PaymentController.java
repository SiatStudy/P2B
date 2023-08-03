package com.example.p2b.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class PaymentController {
    @GetMapping("/member/payment")
    public String payment(){
        return "payment";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }
}
