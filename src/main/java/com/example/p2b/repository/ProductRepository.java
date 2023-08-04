package com.example.p2b.repository;

import com.example.p2b.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPdtype(int category);

    List<Product> findByPdlocal(int location);

    List<Product> findByPdnameContaining(String name);

    List<Product> findByPdid(Long id);
}
