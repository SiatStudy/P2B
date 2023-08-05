package com.example.p2b.dto;

import com.example.p2b.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInDTO {
    private int pdprice;
    private String pdname;
    private User user;
}
