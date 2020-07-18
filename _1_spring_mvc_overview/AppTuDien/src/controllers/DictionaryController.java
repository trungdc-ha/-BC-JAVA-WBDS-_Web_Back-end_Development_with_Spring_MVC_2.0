package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/dictinonary")
    public String getDictionary() {
        return "dictionary";
    }

    @PostMapping("/dictinonary")
    public ModelAndView findWord(@RequestParam(name = "word") String word) {
        Map<String, String> dic = new HashMap<>();
        dic.put("people", "nguoi");
        dic.put("history", "lich su");
        dic.put("way", "con duong");
        dic.put("art", "nghe thuat");
        dic.put("world", "the gioi");
        dic.put("information", "thong tin");
        dic.put("map", "ban do");

        String vnWord = dic.get(word);

        ModelAndView modelAndView = new ModelAndView("dictionary", "word", word);
        if (vnWord == null) {
            modelAndView.addObject("result", "Not Found");
        } else {
            modelAndView.addObject("result", vnWord);
        }
        return modelAndView;
    }
}
