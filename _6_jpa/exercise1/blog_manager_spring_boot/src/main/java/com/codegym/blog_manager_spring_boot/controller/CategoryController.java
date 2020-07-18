package com.codegym.blog_manager_spring_boot.controller;


import com.codegym.blog_manager_spring_boot.model.Blog;
import com.codegym.blog_manager_spring_boot.model.Category;
import com.codegym.blog_manager_spring_boot.service.BlogService;
import com.codegym.blog_manager_spring_boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/category")
    public ModelAndView listcategory(){
        return new ModelAndView("category/list","categories", categoryService.findAll());
    }
    @GetMapping("/create-category")
    public ModelAndView createcategory(){
        return new ModelAndView("category/create","category", new Category());
    }
    @PostMapping("/create-category")
    public ModelAndView createcategory(@ModelAttribute(name = "category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category !=null) {
            return new ModelAndView("category/edit","category", category);
        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-category")
    public ModelAndView updatecategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category !=null) {
            ModelAndView modelAndView = new ModelAndView("category/delete");
            modelAndView.addObject("category", category);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-category")
    public String deletecategory(@ModelAttribute("category") Category category){
        categoryService.remove(category.getIdCategory());
        return "redirect:/category";
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView viewcategory(@PathVariable("id") Long id){
        Category category = categoryService.findById(id);
        if(category ==null){
            return new ModelAndView("/error.404");
        }

        Iterable<Blog> blogs= blogService.findById(category);
        ModelAndView modelAndView = new ModelAndView("category/view");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("categories", category);
        return modelAndView;
    }

}
