package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.user.LoginUserDto;
import com.kodilla.ecommercee.entity.SessionEntity;
import com.kodilla.ecommercee.entity.UserEntity;
import com.kodilla.ecommercee.repository.SessionRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public UserEntity saveUser(final UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    public void banUser(final Long id) {
        if (userRepository.findById(id).isPresent()) {
            UserEntity user = userRepository.findById(id).get();
            user.setStatus(0);
            userRepository.save(user);
        }
    }

    public boolean attemptLogin(LoginUserDto loginUserDto) {
        Optional<UserEntity> userOpt = userRepository.findByLoginAndPassword(loginUserDto.getLogin(), loginUserDto.getPassword());
        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            if (user.getStatus() == 1) {
                generateSession(user);
                return true;
            }
        }
        return false;
    }

    private void generateSession(UserEntity user) {
        Random random = new Random();
        String userKey = String.valueOf(Objects.hash(user.getLogin()))
                .concat(String.valueOf(random.nextInt(Integer.MAX_VALUE)));

        user.setUserKey(userKey);
        userRepository.save(user);

        SessionEntity session = new SessionEntity();
        session.setLastActivity(LocalDate.now());
        session.setUserKey(userKey);
        sessionRepository.save(session);
    }
}
