package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.entity.OrderEntity;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<OrderEntity> getOrders(){
        return orderRepository.findAll();
    }

    public Optional<OrderEntity> getOrder(final Long id){
        return orderRepository.findById(id);
    }

    public void deleteById(final Long id){
        orderRepository.deleteById(id);
    }

    public OrderEntity saveOrder(final OrderEntity order){
        return orderRepository.save(order);
    }

}
