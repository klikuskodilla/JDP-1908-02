package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CartRepository extends CrudRepository<CartEntity, Integer> {
    @Override
    List<CartEntity> findAll();

    @Override
    Optional<CartEntity> findById(Integer id);

    @Override
    CartEntity save(CartEntity cartEntity);

    @Override
    void deleteById(Integer id);
}
