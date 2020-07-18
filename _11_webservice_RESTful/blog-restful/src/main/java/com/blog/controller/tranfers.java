package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class tranfers {
    @GetMapping("/")
    public String writing(){
        return "/writing/list";
    }
}
