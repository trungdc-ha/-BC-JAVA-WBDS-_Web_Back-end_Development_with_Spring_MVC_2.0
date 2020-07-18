package com.codegym.blog_manager_spring_boot.service.impl;

import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.User;
import com.codegym.blog_manager_spring_boot.repository.BlogRepository;
import com.codegym.blog_manager_spring_boot.service.BlogService;
import com.codegym.blog_manager_spring_boot.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
class BlogServiceImplTest {
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
        public BlogRepository blogRepository() {
            return Mockito.mock(BlogRepository.class);
        }
    }
    @Autowired
    private BlogService blogService;

    @Autowired UserService userService;

    @MockBean
    private BlogRepository blogRepository;
    @Test
    void findAll() {
        List<Blog> blogList = new ArrayList<>();
        blogList.add(new Blog("Hai tan codegym", new User()));
        Pageable pageInfo = PageRequest.of(0, 25);
        Page<Blog> blogs = new PageImpl<Blog>(blogList, pageInfo, 1);
        when(blogRepository.findAll(pageInfo)).thenReturn(blogs);

        Page<Blog> actual = blogService.findAll(pageInfo);
        verify(blogRepository).findAll(pageInfo);
        assertEquals(blogs, actual);
    }

    @Test
    void findById() {
        Blog blog = new Blog("hai tan",new User());
        when(blogRepository.findById(1L)).thenReturn(java.util.Optional.of(blog));

        Blog actual = blogService.findById(1L);
        verify(blogRepository).findById(1L);
        assertEquals(blog, actual);
    }

    @Test
    void save() {
        Blog blog = new Blog("Hai tan",new User());
        blogService.save(blog);
        verify(blogRepository).save(blog);
    }

    @AfterEach
    private void resetMocks() {
        Mockito.reset(blogRepository);
    }
}