package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {
    public static final String CONVERT = "convert";

    @GetMapping("/convert")
    public ModelAndView convertForm() {
        ModelAndView modelAndView = new ModelAndView(CONVERT);
        modelAndView.addObject("usd", 0);
        modelAndView.addObject("rate", 0);
        modelAndView.addObject("result", "");
        return modelAndView;
    }

    @PostMapping("/convert")
    public ModelAndView convert(@RequestParam("usd") String money, @RequestParam("rate") String rate) {
        ModelAndView modelAndView = new ModelAndView(CONVERT);
        try {
            double usd = Double.parseDouble(money);
            double rateEX = Double.parseDouble(rate);
            modelAndView.addObject("result", usd * rateEX);
        } catch (NumberFormatException e) {
            modelAndView.addObject("result", "error");
        }
        modelAndView.addObject("usd", money);
        modelAndView.addObject("rate", rate);
        return modelAndView;
    }
}
