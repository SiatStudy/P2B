package com.example.p2b.service;

import com.example.p2b.domain.Product;
import com.example.p2b.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findProductCategory(int category){
        List<Product> categoryList = productRepository.findByPdtype(category);
        return categoryList;
    }

    public List<Product> findProductLocation(int location){
        List<Product> locationList = productRepository.findByPdlocal(location);
        return locationList;
    }

    public List<Product> findProductName(String item){
        List<Product> itemList = productRepository.findByPdnameContaining(item);
        return itemList;
    }

    public List<Product> findProductId(Long id){
        List<Product> productList = productRepository.findByPdid(id);
        return productList;
    }

    public int findProductPrice(String name){
        int productPrice = productRepository.findByPdname(name).getPdprice();
        return productPrice;
    }
}
