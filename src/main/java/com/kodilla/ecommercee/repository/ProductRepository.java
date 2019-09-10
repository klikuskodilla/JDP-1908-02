package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Override
    List<ProductEntity> findAll();

    @Override
    Optional<ProductEntity> findById(Long id);

    @Override
    ProductEntity save(ProductEntity productEntity);

    @Override
    void deleteById(Long id);
}