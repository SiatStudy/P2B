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

    @Column(name = "PRODUCT_LOCAL")
    private int pdlocal;

    @Column(name = "PRODUCT_POINT")
    private double pdpoint;

    @Column(name = "PRODUCT_PRICE")
    private int pdprice;

    @Column(name = "PRODUCT_WED_PRICE")
    private int pdwedprice;

    @ManyToOne
    @JoinColumn(name = "mem_id")
    private User user;

    public Prefer(String pdname, int pdtype, String pdaddr, String pdtel, int pdlocal, double pdpoint, int pdprice, int pdwedprice, User user) {
        this.pdname = pdname;
        this.pdtype = pdtype;
        this.pdaddr = pdaddr;
        this.pdtel = pdtel;
        this.pdlocal = pdlocal;
        this.pdpoint = pdpoint;
        this.pdprice = pdprice;
        this.pdwedprice = pdwedprice;
        this.user = user;
    }
}
