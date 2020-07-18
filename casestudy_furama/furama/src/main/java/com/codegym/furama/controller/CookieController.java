package com.codegym.furama.controller;

import com.codegym.furama.entity.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CookieController {
    @GetMapping("/cookie")
    public ModelAndView getHistoryPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("contact/cookie");
        Cookie[] cookies = request.getCookies();
        List<Contact> contactList = new ArrayList<>();

        Contact contact;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().contains("contact")) {
                contact = new Contact();
                String[] cookiaValue = cookies[i].getValue().split("\\_");
                contact.setCustomerId(cookiaValue[0]);
                contact.setStartDate(cookiaValue[1]);
                contact.setEndDate(cookiaValue[2]);
                contact.setServiceId(cookiaValue[3]);
                contactList.add(contact);
            }
        }
        modelAndView.addObject("cookieContactList", contactList);

        return modelAndView;
    }
}
