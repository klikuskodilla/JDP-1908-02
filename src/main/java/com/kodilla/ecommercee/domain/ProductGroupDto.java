package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductGroupDto {
    private Long id;
    private String name;

    public ProductGroupDto(String name) {
        this.name = name;
    }
}
