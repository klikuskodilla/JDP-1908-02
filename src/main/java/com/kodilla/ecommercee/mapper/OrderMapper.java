package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.entity.CartEntity;
import com.kodilla.ecommercee.entity.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderEntity mapToOrder(final OrderDto orderDto){
        return new OrderEntity(
                orderDto.getOrderId(),
                orderDto.getDate(),
                new CartEntity()
        );
    }

    public OrderDto mapToOrderDto(final OrderEntity order){
        return new OrderDto(
                order.getOrderId(),
                order.getDateOfOrder()
        //        order.getCartEntity()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<OrderEntity> orderList){
        return orderList.stream()
                .map(o -> new OrderDto(o.getOrderId(), o.getDateOfOrder()))
                .collect(Collectors.toList());
    }
}

