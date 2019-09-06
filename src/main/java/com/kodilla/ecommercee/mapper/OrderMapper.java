package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.entity.OrderEntity;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    CartService cartService;


    public OrderEntity mapToOrder(final OrderDto orderDto){

        return new OrderEntity(
                orderDto.getOrderId(),
                orderDto.getDate(),
                cartService.getCart(orderDto.getCartId()).orElse(null)
        );
    }

    public OrderDto mapToOrderDto(final OrderEntity order){
        return new OrderDto(
                order.getOrderId(),
                order.getDateOfOrder(),
                order.getCartEntity().getUserEntity().getId(),
                order.getCartEntity().getCartId()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<OrderEntity> orderList){
        return orderList.stream()
                .map(o -> new OrderDto(o.getOrderId(), o.getDateOfOrder(), o.getCartEntity().getUserEntity().getId(), o.getCartEntity().getCartId()))
                .collect(Collectors.toList());
    }
}

