package com.codegym.blog_manager_spring_boot.service;

import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.User;

public interface UserService {

    Iterable<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);
}
