package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

    @Override
    List<OrderEntity> findAll();

    Optional<OrderEntity> findById(Long id);

    void deleteById(Long id);
}
