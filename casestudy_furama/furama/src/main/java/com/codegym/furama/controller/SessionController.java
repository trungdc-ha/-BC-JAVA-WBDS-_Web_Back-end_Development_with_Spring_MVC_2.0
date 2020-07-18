package com.codegym.furama.controller;

import com.codegym.furama.entity.ServiceF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SessionController {

    @GetMapping("/session")
    public ModelAndView getListServiceF(Pageable pageable, Model model, HttpServletRequest request) {
        ServiceF serviceF = (ServiceF) request.getSession().getAttribute("serviceF");
        List<ServiceF> serviceFList = new ArrayList<ServiceF>();
        serviceFList.add(serviceF);

        ModelAndView modelAndView = new ModelAndView("serviceF/index", "serviceFList", serviceFList);
        return modelAndView;
    }
}
