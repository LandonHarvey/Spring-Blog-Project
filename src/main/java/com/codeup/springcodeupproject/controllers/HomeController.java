package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.repositories.AdventureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final AdventureRepository advDao;

    public HomeController (AdventureRepository advDao){
        this.advDao = advDao;
    }

    @GetMapping("/")
    public String all(Model model){
        model.addAttribute("adventures", advDao.findAll());
        return "home";
    }
}