package com.kodilla.ecommercee.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.engine.internal.Cascade;

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

	@ElementCollection(targetClass = Integer.class)
	@MapKeyClass(ProductEntity.class)
	@CollectionTable(name = "TEST_MAP2")
	@Fetch(value = FetchMode.JOIN)
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

	//konstruktor na potrzeby testów

	public CartEntity(UserEntity userEntity, Map<ProductEntity, Integer> productMap) {
		this.userEntity = userEntity;
		this.productMap = productMap;
	}
}
