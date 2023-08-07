package com.example.p2b.controller;

import com.example.p2b.domain.Product;
import com.example.p2b.domain.User;
import com.example.p2b.service.PreferService;
import com.example.p2b.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;
    private final PreferService preferService;

    @GetMapping("/location")
    public String mainPageByLocation(@RequestParam("location") int location,
                                     Model model){
        List<Product> locationList = productService.findProductLocation(location);
        model.addAttribute("locationList", locationList);
        return "product";
    }

    @GetMapping("/category")
    public String mainPageByCategory(@RequestParam("category") int category,
                                     Model model){
        List<Product> categoryList = productService.findProductCategory(category);
        model.addAttribute("categoryList", categoryList);
        return "product";
    }

    @GetMapping("/item")
    public String mainPage3(@RequestParam("item") String item){
        return "redirect:/users/main";
    }

    @GetMapping("/product")
    public String mainPage4(@RequestParam("product") String name){
        return "redirect:/users/main";
    }

    @PostMapping("/prefer")
    public String addPrefer(String pdname, User user){
        // pdname으로 DB에서 모든 상품 정보 받아와서 addPrefer를 통해 저장
        Product product =  productService.findProduct(pdname);
        preferService.addPrefer(product.getPdname(), product.getPdtype(), product.getPdaddr(), product.getPdtel(), product.getPdlocal(), product.getPdpoint(), product.getPdprice(), product.getPdwedprice(), user);
        return "redirect:/main";
    }

    @GetMapping("/payment")
    public String paymentPage(){
        return "payment";
    }
}