package com.codeup.springwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceController {
    @GetMapping("/roll-dice/{number}")
    public String showPage(@PathVariable String number, Model model){
        model.addAttribute(" number", number);
        return "dice";
    }

    @PostMapping("/roll-dice")
    public String showGuess(@RequestParam(name = "number") String number, Model model){
            model.addAttribute("number", number);
            return "dice";
    }

}
