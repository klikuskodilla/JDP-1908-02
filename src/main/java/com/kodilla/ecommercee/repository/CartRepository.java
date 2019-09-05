package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CartRepository extends CrudRepository<CartEntity, Integer> {
}
