package com.sergsnmail.jspringboot4.exception.product;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
