package com.codegym.blog_manager_spring_boot.service;

import com.codegym.blog_manager_spring_boot.model.Category;

public interface CategoryService {

    Iterable<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
