package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.CartDtoCreateCart;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.CartEntity;
import com.kodilla.ecommercee.entity.ProductEntity;
import com.kodilla.ecommercee.service.ProductService;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartMapper {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    public CartEntity mapToCartEntity(final CartDto cartDto) {
        return new CartEntity(
                cartDto.getCartId(),
                cartDto.getUserEntity(),
                cartDto.getProductMap());
    }

    public CartEntity mapToCartEntityCreateCart(final CartDtoCreateCart cartDtoCreateCart) {
        Map<ProductEntity, Integer> mapInEntity = new HashMap<>();
        Map<Long, Integer> mapInDto = cartDtoCreateCart.getProducts();
        for(Map.Entry<Long, Integer> map: mapInDto.entrySet()){
            Long id = map.getKey();
            ProductEntity product = productService.getProduct(id).orElse(null);
            mapInEntity.put(product, map.getValue());
        }
        return new CartEntity(
                cartDtoCreateCart.getCartId(),
                userService.getUser(cartDtoCreateCart.getUserId()).orElse(null),
                mapInEntity
        );
    }

    public CartDto mapToCartDto(final CartEntity cartEntity) {
        return new CartDto(
                cartEntity.getCartId(),
                cartEntity.getUserEntity(),
                cartEntity.getProductMap()
        );
    }

    public Map<ProductDto, Integer> mapToProductDtoMap(final CartEntity cartEntity) {
        Map<ProductDto, Integer> productDtoMap = new HashMap<>();
        for(Map.Entry<ProductEntity, Integer> entry : cartEntity.getProductMap().entrySet()) {
            productDtoMap.put(productMapper.mapToProductDto(entry.getKey()), entry.getValue());
        }
        return productDtoMap;
    }

    public Map<ProductEntity, Integer> mapToProductEntityMap(final Map<ProductDto, Integer> products) {
        Map<ProductEntity, Integer> productEntitiesMap = new HashMap<>();
        for(Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            productEntitiesMap.put(productMapper.mapToProduct(entry.getKey()), entry.getValue());
        }
        return productEntitiesMap;
    }
}
