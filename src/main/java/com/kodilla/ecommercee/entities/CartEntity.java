package com.kodilla.ecommercee.entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "CART")
public class CartEntity {
	@Id
	@GeneratedValue
	@Column(name = "CART_ID", nullable = false)
	private int cartId;
	@Column(name = "USER", nullable = false)
	private UserEntity user;
	@Column(name = "PRODUCT", nullable = false)
	private List<ProductEntity> products = new ArrayList<>();

	public CartEntity() {}

	public CartEntity(UserEntity user, List<ProductEntity> products) {
		this.user = user;
		this.products = products;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}

	@OneToMany (targetEntity = ProductEntity.class, mappedBy = "cartEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<ProductEntity> getProducts() {
		return products;
	}
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
}
