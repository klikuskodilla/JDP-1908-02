package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "order_id", unique = true)
    private Long orderId;

    @Column(name = "order_date")
    @NotNull
    private LocalDate dateOfOrder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID")
    private CartEntity cartEntity;

    public OrderEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
    }

    public OrderEntity(@NotNull LocalDate dateOfOrder, CartEntity cartEntity) {
        this.dateOfOrder = dateOfOrder;
        this.cartEntity = cartEntity;
    }
}
