package com.kodilla.ecommercee.domain.order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "orders_list")
public class Order {

    private Long orderId;

    private User user;

    private Cart cart;

    private LocalDate dateOfOrder;

    public Order() {
    }

    public Order(Long orderId, User user, Cart cart, LocalDate dateOfOrder) {
        this.orderId = orderId;
        this.user = user;
        this.cart = cart;
        this.dateOfOrder = dateOfOrder;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "order_id", unique = true)
    public Long getOrderId() {
        return orderId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    public Cart getCart() {
        return cart;
    }

    @Column(name = "order_date")
    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
