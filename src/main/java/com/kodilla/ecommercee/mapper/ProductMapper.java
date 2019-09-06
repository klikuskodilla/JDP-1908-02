package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.ProductEntity;
import com.kodilla.ecommercee.entity.ProductGroupEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductEntity mapToProduct(final ProductDto productDto) {
        return new ProductEntity(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getDescription(),
                new ProductGroupEntity());
    }

    public ProductDto mapToProductDto(final ProductEntity productEntity) {
        return new ProductDto(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getDescription());
    }

    public List<ProductDto> mapToProductDtoList(final List<ProductEntity> productEntityList) {
        return productEntityList.stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice(), p.getDescription()))
                .collect(Collectors.toList());
    }
}
