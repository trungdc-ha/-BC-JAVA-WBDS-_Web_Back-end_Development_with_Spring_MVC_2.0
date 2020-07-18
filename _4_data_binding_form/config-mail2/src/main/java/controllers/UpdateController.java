package controllers;

import model.ConfigEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class UpdateController {

    @GetMapping("/update")
    public String index(Model model) {
        model.addAttribute("configEmail", new ConfigEmail());
        return "index";
    }

    @RequestMapping("/update")
    public String save(@ModelAttribute("configEmail") ConfigEmail configEmail, Model model) {
        model.addAttribute("configEmail", configEmail);
        return "index";
    }
}
