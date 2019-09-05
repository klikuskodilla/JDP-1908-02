package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
