package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDtoCreateCart {
    private int cartId;
    private Long userId;
    private Map<Long, Integer> products = new HashMap<>();

//    public CartDtoCreateCart(int cartId, Long userId) {
//        this.cartId = cartId;
//        this.userId = userId;
//        this.products = new HashMap<>();
//    }
}
