package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTest {
    @Autowired
    UserRepository repository;

    @Test
    public void testUserEntitySave(){
        //given
        UserEntity user = new UserEntity();

        //when
        repository.save(user);

        //then
        long id = user.getId();
        Optional<UserEntity> newUser = repository.findById(id);
        Assert.assertTrue(newUser.isPresent());

        //cleanUp
        repository.deleteById(id);
    }
}
