package com.codegyn.form_validate.Service;


import com.codegyn.form_validate.model.User;

import java.util.List;

public interface UserService {
    Iterable<User> findAll();

    User findById(Long id);

    void save(User User);

    void remove(Long id);
}

