package com.codegym.blog_manager_spring_boot.controller;


import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.User;
import com.codegym.blog_manager_spring_boot.service.BlogService;
import com.codegym.blog_manager_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/users")
    public ModelAndView listUser(Pageable pageable){
        return new ModelAndView("user/list","users",userService.findAll(pageable));
    }
    @GetMapping("/create-user")
    public ModelAndView createUser(){
        return new ModelAndView("user/create","user", new User());
    }
    @PostMapping("/create-user")
    public ModelAndView createUser(@ModelAttribute(name = "user") User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "New user created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        User user = userService.findById(id);
        if(user!=null) {
            return new ModelAndView("user/edit","user",user);
        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-user")
    public ModelAndView updateUser(@ModelAttribute("user") User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("user/edit");
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "User updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-user/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        User user = userService.findById(id);
        if(user!=null) {
            ModelAndView modelAndView = new ModelAndView("user/delete");
            modelAndView.addObject("user", user);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-user")
    public String deleteUser(@ModelAttribute("user") User user){
        userService.remove(user.getIdUser());
        return "redirect:/users";
    }

    @GetMapping("/view-uses/{id}")
    public ModelAndView viewUser(@PathVariable("id") Long id, Pageable pageable){
        User user = userService.findById(id);
        if(user==null){
            return new ModelAndView("/error.404");
        }

        Iterable<Blog> blogs= blogService.findByUser(user,pageable);
        ModelAndView modelAndView = new ModelAndView("user/view");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("uses", user);
        return modelAndView;
    }

}
