package com.codegym.blog_manager_spring_boot.repository;

import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Iterable<Blog> findByUser(User user);
}
