package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "orders_list")
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

//    Zgodnie z radą naszego mentora, komentuję referencję do klasy, której jeszcze nie ma zmerge'owanej
//    Tak w każdym razie wyglądać ma pełna konstrukcja encji Cart
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
}
