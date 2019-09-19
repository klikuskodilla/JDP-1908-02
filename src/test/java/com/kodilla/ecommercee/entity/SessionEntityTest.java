package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.repository.SessionRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionEntityTest {

    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void testSessionEntitySave(){
        //given
        SessionEntity session = new SessionEntity();

        //when
        sessionRepository.save(session);

        //then
        long id = session.getId();
        Optional<SessionEntity> newSession = sessionRepository.findById(id);
        assertTrue(newSession.isPresent());

        //cleanUp
        sessionRepository.deleteById(id);
    }
}