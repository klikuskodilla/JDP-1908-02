package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private LocalDate date;
    private Integer userId;
    private int cartId;
}
