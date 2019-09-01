package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CARTS")
public class CartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CART_ID", nullable = false)
	private int cartId;
//	@Column(name = "TO_PAY", nullable = false)
//	private double toPay;
	@Column(name = "PRODUCT_QUANTITY", nullable = false)
	private int productQuantity;

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "USER_ID")
//	private UserEntity userEntity;

//	@OneToMany(targetEntity = ProductEntity.class, mappedBy = "cartEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<ProductEntity> productList = new ArrayList<>();
}
