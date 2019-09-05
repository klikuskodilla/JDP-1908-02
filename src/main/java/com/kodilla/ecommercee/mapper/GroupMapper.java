package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.ProductGroupDto;
import com.kodilla.ecommercee.entity.ProductGroupEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {
    public ProductGroupEntity mapToProductGroupEntity(final ProductGroupDto groupDto) {
        return new ProductGroupEntity(
                groupDto.getId(),
                groupDto.getName(),
                Collections.emptyList());
    }

    public ProductGroupDto mapToProductGroupDto(final ProductGroupEntity groupEntity) {
        return new ProductGroupDto(
                groupEntity.getId(),
                groupEntity.getGroupName());
    }

    public List<ProductGroupDto> mapToProductGroupDtoList(final List<ProductGroupEntity> groupEntities) {
        return groupEntities.stream()
                .map(g -> new ProductGroupDto(g.getId(), g.getGroupName()))
                .collect(Collectors.toList());
    }
}
