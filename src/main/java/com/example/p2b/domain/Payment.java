package com.example.p2b.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private Long pmid;

    @Column(name = "PAYMENT_TIME")
    private LocalDateTime pmtime = LocalDateTime.now();

    @Column(name = "PRODUCT_PRICE")
    private int pdprice;

    @Column(name = "PRODUCT_NAME")
    private String pdname;

    @ManyToOne
    @JoinColumn(name = "mem_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
