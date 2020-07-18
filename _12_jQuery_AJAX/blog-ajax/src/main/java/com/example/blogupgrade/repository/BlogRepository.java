package com.example.blogupgrade.repository;

import com.example.blogupgrade.model.Blog;
import com.example.blogupgrade.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Iterable<Blog> findAllByCategory(Category category);
    List<Blog> findAllByNameBlogContaining(String search);
}
