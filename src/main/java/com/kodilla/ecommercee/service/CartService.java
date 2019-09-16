package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.entity.CartEntity;
import com.kodilla.ecommercee.entity.ProductEntity;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public Optional<CartEntity> getCart(int id){
        return cartRepository.findById(id);
    }

    public CartEntity saveCart(final CartEntity cartEntity) {
        return cartRepository.save(cartEntity);
    }

    public CartEntity addProducts(final int cartId, Map<ProductEntity, Integer> products) {
        Map<ProductEntity, Integer> productsInCart = cartRepository.findById(cartId).orElse(null).getProductMap();

        for(Map.Entry<ProductEntity, Integer> entry : products.entrySet()) {
            if(!productsInCart.containsKey(entry.getKey())) {
                productsInCart.put(entry.getKey(), entry.getValue());
            } else {
                Integer value = productsInCart.get(entry.getKey());
                value += entry.getValue();
                productsInCart.put(entry.getKey(), value);
            }
        }
        CartEntity updatedCart = new CartEntity(cartId, cartRepository.findById(cartId).orElse(null).getUserEntity(), productsInCart);
        return updatedCart;
    }

    public CartEntity deleteProduct(final int cartId, final Long id) {
        Map<ProductEntity, Integer> productsInCart = cartRepository.findById(cartId).orElse(null).getProductMap();
        productsInCart.remove(id);
        CartEntity updatedCart = new CartEntity(cartId, cartRepository.findById(cartId).orElse(null).getUserEntity(), productsInCart);
        return updatedCart;
    }

    public void deleteCart(final int id) {
        cartRepository.deleteById(id);
    }
}
