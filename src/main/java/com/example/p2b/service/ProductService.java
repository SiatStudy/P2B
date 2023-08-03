package com.example.p2b.service;

import com.example.p2b.domain.Product;
import com.example.p2b.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    @Transactional
    public void addProduct(){
        Product product1 = new Product();
        product1.setPdname("어떤 호텔1");
        product1.setPdaddr("어떤시 어떤구 어떤동");
        product1.setPdpoint(4.7);
        product1.setPdprice(27000);
        product1.setPdwedprice(47000);
        product1.setPdlocal(1);
        product1.setPdtel("010-1111-1111");
        product1.setPdtype(3);

        Product product2 = new Product();
        product2.setPdname("어떤 호텔2");
        product2.setPdaddr("어떤시 어떤구 어떤동");
        product2.setPdpoint(4.7);
        product2.setPdprice(28000);
        product2.setPdwedprice(48000);
        product2.setPdlocal(1);
        product2.setPdtel("010-1111-1111");
        product2.setPdtype(2);

        Product product3 = new Product();
        product3.setPdname("어떤 호텔3");
        product3.setPdaddr("어떤시 어떤구 어떤동");
        product3.setPdpoint(4.7);
        product3.setPdprice(29000);
        product3.setPdwedprice(49000);
        product3.setPdlocal(2);
        product3.setPdtel("010-1111-1111");
        product3.setPdtype(3);

        Product product4 = new Product();
        product4.setPdname("어떤 호텔4");
        product4.setPdaddr("어떤시 어떤구 어떤동");
        product4.setPdpoint(4.7);
        product4.setPdprice(26000);
        product4.setPdwedprice(46000);
        product4.setPdlocal(2);
        product4.setPdtel("010-1111-1111");
        product4.setPdtype(3);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
    }
}
