package com.kodilla.ecommercee.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Table(name = "products_group")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "group_id", unique = true)
    private Long groupId;

    @Column(name = "group_name")
    @NotNull
    private Long groupName;

//    Zgodnie z radą naszego mentora, komentuję referencję do klasy, której jeszcze nie ma zmerge'owanej
//    Tak w każdym razie wyglądać ma pełna konstrukcja encji Product
//
//    @OneToOne(
//            targetEntity = Product.class,
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//            mappedBy = "products_group"
//    )
//    private List<Product> products = new ArrayList<>();

}
