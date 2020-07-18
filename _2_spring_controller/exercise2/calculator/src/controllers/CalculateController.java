package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Controller
public class CalculateController {

    @GetMapping("/calculate")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(
            @RequestParam double firstNum
            , @RequestParam double secondNum
            , @RequestParam String sign
            , Model model) throws ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(firstNum + sign + secondNum);
        model.addAttribute("result", result);

        model.addAttribute("firstNum", firstNum);
        model.addAttribute("secondNum", secondNum);

        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }
}
