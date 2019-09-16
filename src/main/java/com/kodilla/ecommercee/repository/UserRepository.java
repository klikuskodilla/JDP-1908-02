package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Override
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    void deleteById(Long id);

    boolean existsByUserKey(int id);

    Optional<UserEntity> findByLoginAndPassword(String login, String password);
}
