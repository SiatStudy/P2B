package com.example.p2b.controller;

import com.example.p2b.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/save")
    public String saveProduct(){
        productService.addProduct();
        return "redirect:/";
    }
}
