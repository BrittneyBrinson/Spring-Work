package com.codeup.springwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {
    @GetMapping("/hello")
    @ResponseBody
    public String landingPage(){
        return "This is the landing page!";
    }
}
