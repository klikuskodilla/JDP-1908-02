package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.entity.CartEntity;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public Optional<CartEntity> getCart(int id){
        return cartRepository.findById(id);
    }
}
