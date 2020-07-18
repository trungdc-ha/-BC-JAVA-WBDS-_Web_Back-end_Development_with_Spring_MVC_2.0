package com.codegym.furama.controller;

import com.codegym.furama.entity.ServiceF;
import com.codegym.furama.service.ServiceFService;
import com.codegym.furama.service.TypeOfServiceFService;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ServiceFController {

    @Autowired
    ServiceFService serviceFService;

    @Autowired
    TypeOfServiceFService typeOfServiceFService;

    @GetMapping("/add_serviceF")
    public String goAddServiceF(Model model) {
        model.addAttribute("serviceF", new ServiceF());
        model.addAttribute("typeOfServiceFList", typeOfServiceFService.getAllTypeOfServiceF());
        return "serviceF/add_serviceF";
    }

    @PostMapping("/add_serviceF")
    public String addServiceF(@Valid @ModelAttribute("serviceF") ServiceF serviceF, BindingResult bindingResult, Model model,
                              HttpServletRequest request) {

        new ServiceF().validate(serviceF, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("typeOfServiceFList", typeOfServiceFService.getAllTypeOfServiceF());
            return "serviceF/add_serviceF";
        } else {
            serviceFService.addServiceF(serviceF);

            // add session
            request.getSession().setAttribute("serviceF", serviceF);
            return "redirect:/list_serviceF";
        }
    }

    @GetMapping("/list_serviceF")
    public ModelAndView getListServiceF(@RequestParam("serviceFName") Optional<String> serviceFName,
                                        Pageable pageable,
                                        Model model) {
        Page<ServiceF> serviceFList = null;
        if (serviceFName.isPresent()) {
//            serviceFList = serviceFService.findAllByNameContaining(name.get(), pageable);
//            model.addAttribute("serviceFName", serviceFName.get());
        } else {
            serviceFList = serviceFService.getAllServiceF(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("serviceF/index", "serviceFList", serviceFList);
        return modelAndView;
    }

    @GetMapping("/edit_serviceF")
    public String goEditServiceF(@RequestParam(value = "serviceFId") Long serviceFId, Model model) {
        model.addAttribute("typeOfServiceFList", typeOfServiceFService.getAllTypeOfServiceF());
        model.addAttribute("serviceF", serviceFService.getServiceFById(serviceFId));
        return "serviceF/edit_serviceF";
    }

    @PostMapping("/edit_serviceF")
    public String editServiceF(@ModelAttribute(name = "serviceF") ServiceF serviceF, BindingResult bindingResult) {

        new ServiceF().validate(serviceF, bindingResult);
        if (bindingResult.hasErrors()) {
            return "serviceF/edit_serviceF";
        } else {
            serviceFService.editServiceF(serviceF);
            return "redirect:/list_serviceF";
        }
    }

    @GetMapping("/delete_serviceF")
    public String deleteServiceF(@RequestParam(value = "serviceFId") Long serviceFId) {
        serviceFService.deleteServiceF(serviceFId);
        return "redirect:/list_serviceF";
    }
}
