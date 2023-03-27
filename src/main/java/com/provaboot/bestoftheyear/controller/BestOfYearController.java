package com.provaboot.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BestOfYearController {

    @GetMapping
    public String getHome(Model model){
        model.addAttribute("name", "Enrico");
        return "home";
    }
}
