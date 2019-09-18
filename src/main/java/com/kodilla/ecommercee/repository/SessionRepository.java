package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.SessionEntity;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Long, SessionEntity> {
}
