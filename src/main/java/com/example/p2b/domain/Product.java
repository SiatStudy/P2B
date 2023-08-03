package com.example.p2b.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long pdid;

    @Column(name = "PRODUCT_NAME")
    private String pdname;

    @Column(name = "PRODUCT_TYPE")
    private int pdtype;

    @Column(name = "PRODUCT_ADDR")
    private String pdaddr;

    @Column(name = "PRODUCT_TEL")
    private String pdtel;

    @Column(name = "PRODUCT_LOCAL")
    private int pdlocal;

    @Column(name = "PRODUCT_POINT")
    private double pdpoint;

    @Column(name = "PRODUCT_PRICE")
    private int pdprice;

    @Column(name = "PRODUCT_WED_PRICE")
    private int pdwedprice;
}
