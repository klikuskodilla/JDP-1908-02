package com.kodilla.ecommercee.domain.product;

import com.kodilla.ecommercee.domain.group.Group;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {


    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Group group;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, String description, Group group) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.group = group;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    @NotNull
    public String getName() {
        return name;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "decription")
    public String getDescription() {
        return description;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group getGroup() {
        return group;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}