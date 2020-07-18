package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = {"/category"})
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = {"/"},method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Category>> listCategory(){
        Iterable<Category> categories = categoryService.findAllNoSort();
        if (categories==null){
            return new ResponseEntity<Iterable<Category>>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<Iterable<Category>>(categories, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> view(@PathVariable("id") Category category){

        if (category==null){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Category> edit(@PathVariable("id") Category currentCategory, @RequestBody Category category){
        if (category==null){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        category.setId(currentCategory.getId());
        categoryService.save(category);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Category category, UriComponentsBuilder uriComponentsBuilder){
        categoryService.save(category);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Category> remove(@PathVariable("id") Category category){
        if (category == null){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        else {
            categoryService.remove(category.getId());
            return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
        }
    }
}
