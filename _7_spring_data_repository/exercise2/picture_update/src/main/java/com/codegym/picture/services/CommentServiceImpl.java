package com.codegym.picture.services;

import com.codegym.picture.model.Comment;
import com.codegym.picture.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<Comment> getAllCommentByDate(Pageable pageable) {
        return commentRepository.findAllByCreateAtOrderByCreateAt(pageable);
    }

    @Override
    public void incrementLike(Comment comment) {
        em.merge(comment);
    }

    @Override
    public Comment getById(int id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void insertComment(Comment comment) {
        commentRepository.save(comment);
    }

}
