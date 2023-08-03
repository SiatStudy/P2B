package com.example.p2b.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "prefer")
public class Prefer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PREFER_ID")
    private Long pfid;

    @Column(name = "PRODUCT_NAME")
    private String pdname;

    @Column(name = "PRODUCT_TYPE")
    private int pdtype;

    @Column(name = "PRODUCT_ADDR")
    private String pdaddr;

    @Column(name = "PRODUCT_TEL")
    private String pdtel;

    @Column(name = "PRODUCT_POINT")
    private int pdpoint;

    @Column(name = "PRODUCT_PRICE")
    private int pdprice;
}
