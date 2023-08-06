package com.example.p2b.service;

import com.example.p2b.domain.Prefer;
import com.example.p2b.domain.User;
import com.example.p2b.repository.PreferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PreferService {
    private final PreferRepository preferRepository;
    @Transactional
    public void addPrefer(String pdname, int pdtype, String pdaddr, String pdtel, int pdlocal, float pdpoint, int pdprice, int pdwedprice, User user){
        Prefer prefer = new Prefer(pdname, pdtype, pdaddr, pdtel, pdlocal, pdpoint, pdprice, pdwedprice, user);
        preferRepository.save(prefer);
    }
}
