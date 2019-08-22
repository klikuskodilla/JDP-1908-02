package com.kodilla.ecommercee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;
    private List<GenericEntity> genericEntityList = new ArrayList<>();

    public GenericEntity() {
    }

    public GenericEntity(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {

        return id;
    }

    public List<GenericEntity> getGenericEntityList() {
        return genericEntityList;
    }
}
