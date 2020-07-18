package com.example.blogupgrade.controller;

import com.example.blogupgrade.model.Blog;
import com.example.blogupgrade.model.Category;
import com.example.blogupgrade.repository.BlogRepository;
import com.example.blogupgrade.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/category")
    public ModelAndView listCategory() {
        Iterable<Category> categories = categoryRepository.findAll();
        return new ModelAndView("/category/list", "categories", categories);
    }

    @GetMapping("/create-category")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/category/create", "category", new Category());
    }

    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);

        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "Create Category Succesfull");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category != null) {
            return new ModelAndView("/category/edit", "category", category);
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit-category")
    public ModelAndView editCategory(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);

        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Update category succesfull");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category != null) {
            return new ModelAndView("/category/delete", "category", category);
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category") Category category){
        categoryRepository.deleteById(category.getId());
        return "redirect:category";
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            return new ModelAndView("/error");
        }
        Iterable<Blog> blogs = blogRepository.findAllByCategory(category);
        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category", category);
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
}

