package com.example.p2b.repository;

import com.example.p2b.domain.Prefer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PreferRepository extends JpaRepository<Prefer, Long> {
}
