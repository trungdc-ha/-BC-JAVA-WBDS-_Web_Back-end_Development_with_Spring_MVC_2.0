package com.codegym.picture.services;

import com.codegym.picture.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllCommentByDate();
    void incrementLike(Comment comment);
    Comment getById(int id);
    void insertComment(Comment comment);
}
