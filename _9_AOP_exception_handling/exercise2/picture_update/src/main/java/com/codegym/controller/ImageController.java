package com.codegym.controller;

import com.codegym.exception.ImageException;
import com.codegym.model.Image;
import com.codegym.service.ImageService;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.*;

@Controller
@Aspect
public class ImageController {
   Map<Image, LocalDate> map=new HashMap<>();
    @Autowired
    ImageService imageService;


    @GetMapping("/image/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        return new ModelAndView("image","image",new Image());
    }

    @PostMapping("/image")
    public ModelAndView logImage(@ModelAttribute Image image) throws ImageException {
        List<String> list=new ArrayList<>();
        list.add("Hello");
        list.add("Hi");
        for(String str: list) {
            if(str.equals(image.getFeedback())) {
                writeLog(image);
                throw new  ImageException();
            }
        }
        return new ModelAndView("success");
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.controller.ImageController.logImage(image)),")
    public void writeLog(Image image) {
         map.put(image,LocalDate.now());
    }

    @ExceptionHandler(ImageException.class)
    public String showInputNotAcceptable() {
      return "error";
    }



}
