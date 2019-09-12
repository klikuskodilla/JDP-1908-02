package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "carts", produces = "application/json")
public class CartController {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartService cartService;

    @PostMapping("createCart")
    public void createCart(@RequestBody CartDto cartDto) {
        cartService.saveCart(cartMapper.mapToCartEntity(cartDto));
    }

    @GetMapping("{cartId}")
    public Map<ProductDto, Integer> getProducts(@PathVariable int cartId) throws NotFoundException {
        return cartMapper.mapToProductDtoMap(cartService.getCart(cartId).orElseThrow(NotFoundException::new));
    }

    @PutMapping("{cartId}/products")
    public CartDto addProducts(@PathVariable int cartId, @RequestBody Map<ProductDto, Integer> products) {
        return cartMapper.mapToCartDto(cartService.saveCart(cartService.addProducts(cartId, cartMapper.mapToProductEntityMap(products))));
    }

    @PutMapping("{cartId}/products/{productId}")
    public CartDto removeProduct(@PathVariable int cartId, @PathVariable Long productId) {
        return cartMapper.mapToCartDto(cartService.saveCart(cartService.deleteProduct(cartId, productId)));
    }

    @PostMapping("{cartId}/createOrder")
    public void createOrder(@PathVariable int cartId) {

    }
}