package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.ProductGroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface GroupRepository extends CrudRepository<ProductGroupEntity, Long> {
    @Override
    List<ProductGroupEntity> findAll();

    @Override
    ProductGroupEntity save(ProductGroupEntity entity);

    @Override
    Optional<ProductGroupEntity> findById(Long groupId);
}
