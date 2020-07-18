package com.codegym.picture.services;

import com.codegym.picture.model.Comment;
import org.hibernate.annotations.Persister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> getAllCommentByDate() {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where current_date = c.createAt", Comment.class);
        return query.getResultList();
    }

    @Override
    public void incrementLike(Comment comment) {
        em.merge(comment);
    }

    @Override
    public Comment getById(int id) {
        return em.find(Comment.class,id);
    }

    @Override
    public void insertComment(Comment comment) {
        em.persist(comment);
    }
}
