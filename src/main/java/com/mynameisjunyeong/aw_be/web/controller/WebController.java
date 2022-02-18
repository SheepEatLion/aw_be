package com.mynameisjunyeong.aw_be.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/anonymous-writer")
@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("msg", "i blame on you");
        return "/index";
    }

    @GetMapping("/calendar")
    public String calendar(Model model){
        return "/views/calendar";
    }

    @GetMapping("/best-work")
    public String bestWork(Model model) {
        return "/views/best-work";
    }

    @GetMapping("/recent-work")
    public String recentWork(Model model) {
        return "/views/recent-work";
    }

    @GetMapping("/finish-work")
    public String finishWork(Model model) {
        return "/views/finish-work";
    }

    @GetMapping("/publish-info")
    public String publishInfo(Model model) {
        return "/views/publish-info";
    }

    @GetMapping("/start-work")
    public String startWork(Model model) {
        return "/views/start-work";
    }

    @GetMapping("/not-coming")
    public String notComing(Model model) {
        return "/views/not-coming";
    }


}
