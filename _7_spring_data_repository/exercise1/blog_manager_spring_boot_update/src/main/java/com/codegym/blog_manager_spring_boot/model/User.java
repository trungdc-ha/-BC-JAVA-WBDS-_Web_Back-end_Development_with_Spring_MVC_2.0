package com.codegym.blog_manager_spring_boot.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String firstName;
    private String lastName;
    @OneToMany(targetEntity = Blog.class)
    private List<Blog> blogs;

    public User() {
    }

    public User(String firstName, String lastName, List<Blog> blogs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.blogs = blogs;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return this.firstName+" "+this.lastName;
    }
}
