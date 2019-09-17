package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.controller.ProductGroupNotFoundException;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductGroupDto;
import com.kodilla.ecommercee.entity.ProductEntity;
import com.kodilla.ecommercee.entity.ProductGroupEntity;
import com.kodilla.ecommercee.service.GroupDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private GroupDbService groupDbService;

    public ProductEntity mapToProduct(final ProductDto productDto) {
        return new ProductEntity(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getDescription(),
                groupDbService.getProductGroupById(productDto.getGroupId()).orElse(new ProductGroupEntity()));
    }

    public ProductDto mapToProductDto(final ProductEntity productEntity) {
        return new ProductDto(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getDescription(),
                productEntity.getProductGroupEntity().getId());
    }

    public List<ProductDto> mapToProductDtoList(final List<ProductEntity> productEntityList) {
        return productEntityList.stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice(), p.getDescription(), p.getProductGroupEntity().getId()))
                .collect(Collectors.toList());
    }
}
