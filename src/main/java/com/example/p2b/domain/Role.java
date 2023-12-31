package com.example.p2b.domain;

public enum Role {
    USER("USER"),
    ANONYMOUS("ANONYMOUS");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}