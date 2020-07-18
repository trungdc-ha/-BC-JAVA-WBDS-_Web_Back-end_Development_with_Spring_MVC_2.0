package com.codegym.blog_manager_spring_boot.service;

import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.User;

public interface BlogService {
    Iterable<Blog> findAll();
    Iterable<Blog> findById(User user);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

}
