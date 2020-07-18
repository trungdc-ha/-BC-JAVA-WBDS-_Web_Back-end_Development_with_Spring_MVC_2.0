package com.codegym.blog_manager_spring_boot.service;

import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Iterable<Blog> findById(Category category);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

}
