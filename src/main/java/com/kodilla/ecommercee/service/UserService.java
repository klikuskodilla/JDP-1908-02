package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.user.LoginUserDto;
import com.kodilla.ecommercee.entity.UserEntity;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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

    public boolean attemptLogin(final LoginUserDto loginUserDto) {
        Optional<UserEntity> userOpt = userRepository.findByLoginAndPassword(loginUserDto.getLogin(), loginUserDto.getPassword());
        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            if (user.getStatus() == 1) {
                user.setUserKey(generateSession());
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }

    private String generateSession() {
        return "";
    }
}
