package com.blog.repository;

import com.blog.model.Category;
import com.blog.model.Writing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WritingRepository extends PagingAndSortingRepository<Writing, Long> {
    Iterable<Writing> findAllByCategory(Category category);
    Page<Writing> findAllByTittleContaining(String tittle, Pageable pageable);
}
