package com.codegym.blog_manager_spring_boot.controller;

import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.User;
import com.codegym.blog_manager_spring_boot.service.BlogService;
import com.codegym.blog_manager_spring_boot.service.BlogService;
import com.codegym.blog_manager_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;
    @ModelAttribute("users")
    public Iterable<User> blogs(){
        return userService.findAll();
    }

    @GetMapping({"/blogs","/"})
    public ModelAndView showBlog(){
        return new ModelAndView("blog/list","blogs",blogService.findAll());
    }
    @GetMapping("/create-blog")
    public ModelAndView createBlog(){
        return new ModelAndView("blog/create","blog", new Blog());
    }
    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute(name = "blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog!=null) {
            return new ModelAndView("blog/edit","blog",blog);
        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog!=null) {
            ModelAndView modelAndView = new ModelAndView("blog/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getIdBlog());
        return "redirect:/blogs";
    }
}
