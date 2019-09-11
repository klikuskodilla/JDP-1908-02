package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.GenericEntity;
import com.kodilla.ecommercee.entity.ProductEntity;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "carts", produces = "application/json")
public class CartController {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartService cartService;

    @PostMapping()
    public void createCart(CartDto cartDto) {
        cartService.saveCart(cartMapper.mapToCartEntity(cartDto));
    }

    @GetMapping("{cartId}")
    public Map<ProductDto, Integer> getProducts(@PathVariable int cartId) throws NotFoundException {
        return cartMapper.mapToMapDto(cartService.getCart(cartId).orElseThrow(NotFoundException::new));
    }

    @PutMapping("{cartId}/products")
    public CartDto addProducts(@PathVariable int cartId, @RequestBody Map<ProductEntity, Integer> products) {
        return cartMapper.mapToCartDto(cartService.saveCart(cartService.addProducts(cartId, products)));
    }

    @PutMapping("{cartId}/products/{productId}")
    public CartDto removeProduct(@PathVariable int cartId, @PathVariable Long productId) {
        return cartMapper.mapToCartDto(cartService.saveCart(cartService.deleteProduct(cartId, productId)));
    }

    @PostMapping("{cartId}/createOrder")
    public void createOrder(@PathVariable int cartId) {

    }
}