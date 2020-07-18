package com.codegyn.form_validate.Service.impl;


import com.codegyn.form_validate.Service.UserService;
import com.codegyn.form_validate.model.User;
import com.codegyn.form_validate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User User) {
        userRepository.save(User);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
