package com.mynameisjunyeong.aw_be.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("msg", "i blame on you");
        return "/index";
    }

    @GetMapping("/calendar")
    public String calendar(Model model){
        return "/calendar";
    }
}
