package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    @Override
    List<OrderEntity> findAll();
}
