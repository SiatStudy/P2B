package com.example.p2b.controller;

import com.example.p2b.domain.Payment;
import com.example.p2b.service.PaymentService;
import com.example.p2b.service.ProductService;
import com.example.p2b.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final UserService userService;
    private final ProductService productService;
    private final PaymentService paymentService;

    // front에서 요청온 이름으로 DB를 조회해 상품 가격이 맞는지 확인
    @PostMapping("/payment")
    public boolean paymentReq(String name, int amount){
        System.out.println("---------------- name : " + name);
        System.out.println("---------------- amo : " + amount);
        System.out.println("----- DB에서본 상품 가격 : " + productService.findProductPrice(name));
        if(productService.findProductPrice(name) == amount){
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/payment/success")
    public String paymentSuccess(String username, String pdname, int amount){
        Payment payment = new Payment();
        payment.setPdname(pdname);
        payment.setPdprice(amount);
        payment.setUser(userService.findUser(username));
        paymentService.addPayment(payment);
        return "success";
    }
}