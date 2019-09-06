package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.entity.CartEntity;
import com.kodilla.ecommercee.entity.OrderEntity;
import com.kodilla.ecommercee.entity.UserEntity;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    UserRepository userRepository;


    public OrderEntity mapToOrder(final OrderDto orderDto){

        UserEntity user = userRepository.findById(orderDto.getUserId()).orElse(null);

        return new OrderEntity(
                orderDto.getOrderId(),
                orderDto.getDate(),
                new CartEntity(user, orderDto.getProducts())
        );
    }

    public OrderDto mapToOrderDto(final OrderEntity order){
        return new OrderDto(
                order.getOrderId(),
                order.getDateOfOrder(),
                order.getCartEntity().getUserEntity().getId(),
                order.getCartEntity().getProductMap()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<OrderEntity> orderList){
        return orderList.stream()
                .map(o -> new OrderDto(o.getOrderId(), o.getDateOfOrder(), o.getCartEntity().getUserEntity().getId(), o.getCartEntity().getProductMap()))
                .collect(Collectors.toList());
    }
}

