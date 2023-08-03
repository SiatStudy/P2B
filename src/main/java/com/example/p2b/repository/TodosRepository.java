package com.example.p2b.repository;

import com.example.p2b.domain.User;
import com.example.p2b.domain.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 작업자 : 이건주

public interface TodosRepository extends JpaRepository<Todos, Long> {

    List<Todos> findByTdstartyeardateAndUser(int tdstartyeardate, User user);

}
