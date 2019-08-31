package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products_group")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "group_id", unique = true)
    private Long groupId;

    @Column(name = "group_name")
    @NotNull
    private Long groupName;

    @OneToMany(
            targetEntity = ProductEntity.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "products_group"
    )
    private List<ProductEntity> products = new ArrayList<>();

}
