package com.kodilla.ecommercee.controller.exceptions;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(Long id) {
        super("Product id not found: " + id);
    }
}