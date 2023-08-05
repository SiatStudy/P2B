package com.example.p2b.controller;

import com.example.p2b.domain.Payment;
import com.example.p2b.domain.User;
import com.example.p2b.dto.PaymentInDTO;
import com.example.p2b.service.PaymentService;
import com.example.p2b.service.ProductService;
import com.example.p2b.service.UserService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class VerifyController {

//    private final IamportClient iamportClient;
    private final UserService userService;
    private final ProductService productService;
    private final PaymentService paymentService;


    // 생성자를 통해 REST API 와 REST API secret 입력
//    public VerifyController(){
//        this.iamportClient = new IamportClient("1061256487150552",
//                "552v67vUeyc6JoOGjUz5IOOsX36HfLrreAFuudBoRZl5PFgD55Z6ur8C2n2U3wK8QyBgml3F23bz4nxk");
//    }



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
    public String paymentSuccess(){
        Payment payment = new Payment();
//        payment.setPdname("고양 윌 스테이 호텔");
//        payment.setPdprice(45000);
//        payment.setUser(userService.findUser("leekj21"));
        paymentService.addPayment(payment);
        return "success";
    }
}
