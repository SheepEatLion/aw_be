package com.mynameisjunyeong.aw_be.web.controller;

import com.mynameisjunyeong.aw_be.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RequestMapping("/anonymous-writer")
@Controller
public class WebController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "/login";
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
