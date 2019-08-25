package com.kodilla.ecommercee.domain.group;

import com.kodilla.ecommercee.domain.product.Product;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products_group")
public class Group {

    private Long groupId;
    private Long groupName;
    private List<Product> productsCategories = new ArrayList<>();

    public Group() {
    }

    public Group(Long groupId, Long groupName, List<Product> productsCategories) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.productsCategories = productsCategories;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "group_id", unique = true)
    public Long getGroupId() {
        return groupId;
    }

    @Column(name = "group_name")
    @NotNull
    public Long getGroupName() {
        return groupName;
    }

    @OneToMany(
            targetEntity = Product.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Product> getProductsCategories() {
        return productsCategories;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(Long groupName) {
        this.groupName = groupName;
    }

    public void setProductsCategories(List<Product> productsCategories) {
        this.productsCategories = productsCategories;
    }
}
