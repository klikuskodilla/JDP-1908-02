package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private UserEntity userEntity;

	@ElementCollection
	@MapKeyClass(value = ProductEntity.class)
	@CollectionTable(name = "TEST_MAP2")
	private Map<ProductEntity, Integer> productMap = new HashMap<>();

//	Backup Code
//	@OneToMany(targetEntity = ProductEntity.class, mappedBy = "id", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//	@MapKey(name = "name")
//	private Map<ProductEntity, Integer> productMap = new HashMap<>();

	// konstruktor utworzony na potrzeby Izy
	public CartEntity(int cartId, Map<ProductEntity, Integer> productMap) {
		this.cartId = cartId;
		this.productMap = productMap;
	}
}
