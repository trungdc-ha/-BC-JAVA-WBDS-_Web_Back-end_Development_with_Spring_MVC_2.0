package com.codegym.blog_manager_spring_boot.service.impl;

import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.User;
import com.codegym.blog_manager_spring_boot.repository.BlogRepository;
import com.codegym.blog_manager_spring_boot.repository.UserRepository;
import com.codegym.blog_manager_spring_boot.service.BlogService;
import com.codegym.blog_manager_spring_boot.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    @TestConfiguration
    static class BlogServiceImplTestContextConfiguration {

        @Bean
        public BlogServiceImpl blogService() {
            return new BlogServiceImpl();
        }
        @Bean
        public UserServiceImpl userService() {
            return new UserServiceImpl();
        }
        @Bean
        public UserRepository userRepository() {
            return Mockito.mock(UserRepository.class);
        }
    }
    @Autowired
    private BlogService blogService;

    @Autowired
    UserService userService;

    @MockBean
    private UserRepository userRepository;
    @Test
    void findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User("hai","Tan"));
        Pageable pageInfo = PageRequest.of(0, 25);
//        Page<User> userPage = new PageImpl<Blog>(users, pageInfo, 1);
//        when(userRepository.findAll(pageInfo)).thenReturn(userPage);

        Page<Blog> actual = blogService.findAll(pageInfo);
        verify(userRepository).findAll(pageInfo);
        assertEquals(users, actual);
    }

    @Test
    void findById() {
        User user=new User("hai","tan");
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        User actual = userService.findById(1L);
        verify(userRepository).findById(1L);
        assertEquals(user, actual);
    }

    @Test
    void save() {
        User user = new User("Hai","tan");
        userService.save(user);
        verify(userRepository).save(user);
    }

}