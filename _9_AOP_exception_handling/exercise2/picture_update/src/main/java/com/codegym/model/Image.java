package com.codegym.model;

import org.aspectj.lang.annotation.Aspect;

import javax.persistence.*;

@Entity

@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String feedback;
    private int view;

    public Image() {

    }

    public Image(String title, String describe, int date) {
        this.author = title;
        this.feedback = describe;
        this.view = date;
    }

    @Override
    public String toString() {
        return String.format("Image[ author is %s, feedback is %s, view is %s", author, feedback, view);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
