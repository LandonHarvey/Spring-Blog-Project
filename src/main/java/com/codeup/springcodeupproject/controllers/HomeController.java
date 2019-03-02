package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.repositories.AdventureLogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final AdventureLogRepository adLogDao;

    public HomeController (AdventureLogRepository adLogDao){
        this.adLogDao = adLogDao;
    }

    @GetMapping("/")
    public String all(Model model){
        model.addAttribute("adventures", adLogDao.findAll());
        return "home";
    }
}