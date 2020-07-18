package com.codegym.picture.repository;

import com.codegym.picture.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Page<Comment> findAllByCreateAtOrderByCreateAt(Pageable pageable);
}
