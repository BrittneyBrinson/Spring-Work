package com.codeup.springwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceController {
    @GetMapping("/roll-dice/")
    public String showPage(){
        return "dice";
    }

    @PostMapping("/roll-dice/{n}")
    public String showGuess(@RequestParam(name = "number") int number, Model model){
            model.addAttribute( number);
            return "dice";
    }

}
