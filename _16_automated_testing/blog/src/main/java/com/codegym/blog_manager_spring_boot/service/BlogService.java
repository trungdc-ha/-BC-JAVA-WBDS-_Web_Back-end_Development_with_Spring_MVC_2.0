package com.codegym.blog_manager_spring_boot.service;

import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByUser(User user, Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

}
