package com.codegym.furama.controller;

import com.codegym.furama.entity.Contact;
import com.codegym.furama.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/add_contact")
    public String goAddContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact/add_contact";
    }

    @PostMapping("/add_contact")
    public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult, Model model,
                             HttpServletResponse response) {

        new Contact().validate(contact, bindingResult);
        if (bindingResult.hasErrors()) {
            return "contact/add_contact";
        } else {
            // Add cookie
            String cookieValue = contact.getCustomerId() + "_" + contact.getStartDate() + "_" + contact.getEndDate() +
                    "_" + contact.getServiceId();
            Cookie cookie = new Cookie("contact" + contact.getCustomerId() + contact.getServiceId(), cookieValue);
            cookie.setMaxAge(60*60);
            cookie.setPath("/cookie");
            response.addCookie(cookie);
            contactService.addContact(contact);
            return "redirect:/list_contact";
        }
    }

    @GetMapping("/list_contact")
    public ModelAndView getListContact(@RequestParam("contactName") Optional<String> contactName,
                                        Pageable pageable,
                                        Model model) {
        Page<Contact> contactList = null;
        if (contactName.isPresent()) {
//            contactList = contactService.findAllByNameContaining(name.get(), pageable);
//            model.addAttribute("contactName", contactName.get());
        } else {
            contactList = contactService.getAllContact(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("contact/index", "contactList", contactList);
        return modelAndView;
    }
}
