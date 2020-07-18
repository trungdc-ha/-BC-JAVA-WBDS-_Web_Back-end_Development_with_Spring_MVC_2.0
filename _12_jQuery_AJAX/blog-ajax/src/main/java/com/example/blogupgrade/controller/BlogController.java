package com.example.blogupgrade.controller;

import com.example.blogupgrade.model.Blog;
import com.example.blogupgrade.model.Category;
import com.example.blogupgrade.model.SearchBlogName;
import com.example.blogupgrade.repository.BlogRepository;
import com.example.blogupgrade.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController{
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryRepository.findAll();
    }

    @GetMapping
    public ModelAndView listBlog() {
        Iterable<Blog> blogs = blogRepository.findAll();
        return new ModelAndView("list", "blogs", blogs);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Blog> getListSearch(@RequestBody SearchBlogName search) {
        List<Blog> listBlogs = blogRepository.findAllByNameBlogContaining(search.getBlogName());
        return listBlogs;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/blog/create", "blog", new Blog());
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogRepository.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView showFullBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        if (blog != null) {
            return new ModelAndView("/blog/view", "blog", blog);

        } else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog != null) {
            return new ModelAndView("/blog/edit", "blog", blog);
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView editBlog(@ModelAttribute("blog") Blog blog) {
        blogRepository.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        if (blog != null) {
            return new ModelAndView("/blog/delete", "blog", blog);
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogRepository.deleteById(blog.getId());
        return "redirect:/";
    }
}
