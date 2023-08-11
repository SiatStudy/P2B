package com.example.p2b.repository;

import com.example.p2b.domain.Email;
import com.example.p2b.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailRepository extends JpaRepository<Email, Long> {
    // 이메일 사용자 기준
    Email findByUser(User user);


}
