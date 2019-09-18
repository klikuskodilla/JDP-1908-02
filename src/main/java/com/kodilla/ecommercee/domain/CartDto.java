package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.entity.ProductEntity;
import com.kodilla.ecommercee.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private int cartId;
    private UserEntity userEntity;
    private Map<ProductEntity, Integer> productMap = new HashMap<>();
}
