package com.codegym.picture.services;

import com.codegym.picture.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentService {
    List<Comment> getAllCommentByDate();
    void incrementLike(Comment comment);
    Comment getById(int id);
    void insertComment(Comment comment);
}
