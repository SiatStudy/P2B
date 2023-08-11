package com.example.p2b.controller;

import com.example.p2b.domain.Product;
import com.example.p2b.domain.User;
import com.example.p2b.service.PreferService;
import com.example.p2b.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;
    private final PreferService preferService;

    @GetMapping("/location")
    public @ResponseBody List<Product> mainPageByLocation(@RequestParam("location") int location){
        List<Product> locationList = productService.findProductLocation(location);
        return locationList;
    }

    @GetMapping("/category")
    public @ResponseBody List<Product> mainPageByCategory(@RequestParam("category") int category){
        System.out.println("cate : " + category);
        List<Product> categoryList = productService.findProductCategory(category);
        List<Product> firstTenProducts = categoryList.subList(0, Math.min(categoryList.size(), 10));
        System.out.println("fList : " + firstTenProducts);
        return firstTenProducts;
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