package com.codegym.blog_manager_spring_boot.repository;

import com.codegym.blog_manager_spring_boot.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {

}
