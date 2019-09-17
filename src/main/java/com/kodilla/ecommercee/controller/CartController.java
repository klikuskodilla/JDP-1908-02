package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDtoCreateCart;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.CartEntity;
import com.kodilla.ecommercee.entity.OrderEntity;
import com.kodilla.ecommercee.entity.ProductEntity;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.OrderService;
import com.kodilla.ecommercee.service.ProductService;
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

    @Autowired
    private OrderService orderService;

    @Autowired
    ProductService productService;

    @PostMapping("createCart")
    public void createCart(@RequestBody CartDtoCreateCart cartDtoCreateCart) {
        cartService.saveCart(cartMapper.mapToCartEntityCreateCart(cartDtoCreateCart));
    }

    @GetMapping("{cartId}")
    public Map<ProductDto, Integer> getProducts(@PathVariable Integer cartId) throws NotFoundException {
        return cartMapper.mapToProductDtoMap(cartService.getCart(cartId).orElseThrow(NotFoundException::new));
    }

    @PutMapping("{cartId}/addProduct/{productId}")
    public void addProducts(@PathVariable Integer cartId, @PathVariable Long productId) throws NotFoundException{
        CartEntity cartEntity = cartService.getCart(cartId).orElseThrow(NotFoundException::new);
        ProductEntity productToAdd = productService.getProduct(productId).orElseThrow(NotFoundException::new);
        Map<ProductEntity, Integer> productsInCart = cartEntity.getProductMap();

        if(!productsInCart.containsKey(productToAdd)) {
            productsInCart.put(productToAdd, 1);
        } else {
            Integer value = productsInCart.get(productToAdd);
            value += 1;
            productsInCart.put(productToAdd, value);
        }

        CartEntity updatedCart = new CartEntity(cartId, productsInCart);
        cartService.saveCart(updatedCart);
    }

    @PutMapping("{cartId}/removeProduct/{productId}")
    public void removeProduct(@PathVariable Integer cartId, @PathVariable Long productId) throws NotFoundException{
        CartEntity cartEntity = cartService.getCart(cartId).orElseThrow(NotFoundException::new);
        Map<ProductEntity, Integer> productsInCart = cartEntity.getProductMap();
        ProductEntity productToRemove = productService.getProduct(productId).orElseThrow(NotFoundException::new);

        if(productsInCart.get(productToRemove)>1) {
            Integer value = productsInCart.get(productToRemove);
            value = value - 1;
            productsInCart.put(productToRemove, value);
        } else {
            productsInCart.remove(productToRemove);
        }
        CartEntity updatedCart = new CartEntity(cartId, productsInCart);
        cartService.saveCart(updatedCart);
    }

    @PostMapping("{cartId}/createOrder")
    public void createOrder(@PathVariable Integer cartId) throws NotFoundException {
        CartEntity cartEntity = cartService.getCart(cartId).orElseThrow(NotFoundException::new);
        orderService.saveOrder(new OrderEntity(cartEntity));
        cartService.deleteCart(cartId);
    }
}