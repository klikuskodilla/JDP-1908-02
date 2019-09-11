package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.CartEntity;
import com.kodilla.ecommercee.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartMapper {
    public CartEntity mapToCartEntity(final CartDto cartDto) {
        return new CartEntity(
                cartDto.getCartId(),
                cartDto.getUserEntity(),
                cartDto.getProductMap());
    }

    public CartDto mapToCartDto(final CartEntity cartEntity) {
        return new CartDto(
                cartEntity.getCartId(),
                cartEntity.getUserEntity(),
                cartEntity.getProductMap()
        );
    }

    public Map<ProductDto, Integer> mapToMapDto(final CartEntity cartEntity) {
        Map<ProductDto, Integer> productDtoMap = new HashMap<>();
        for(Map.Entry<ProductEntity, Integer> entry : cartEntity.getProductMap().entrySet()) {
            productDtoMap.put(new ProductDto(entry.getKey().getId(), entry.getKey().getName(), entry.getKey().getPrice(), entry.getKey().getDescription()), entry.getValue());
        }
        return productDtoMap;
    }
}
