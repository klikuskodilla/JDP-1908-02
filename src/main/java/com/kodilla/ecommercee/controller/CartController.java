package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.entity.GenericEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "carts", produces = "application/json")
public class CartController {

    @PostMapping()
    public void createCart() {

    }

    @GetMapping("{cartId}")
    public List<GenericEntity> getProducts(@PathVariable Long cartId) {
        return new ArrayList<>();
    }

    @PostMapping("{cartId}/products")
    public GenericEntity addProducts(@PathVariable Long cartId, @RequestBody List<GenericEntity> productList) {
        return new GenericEntity("addProducts test");
    }

    @DeleteMapping("{cartId}/products/{productId}")
    public boolean removeProduct(@PathVariable Long cartId, @PathVariable Long productId) {
        return true;
    }

    @PostMapping("{cartId}/createOrder")
    public void createOrder(@PathVariable Long cartId) {

    }
}