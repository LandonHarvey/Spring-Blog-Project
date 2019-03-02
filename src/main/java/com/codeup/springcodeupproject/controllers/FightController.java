package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.repositories.AdventureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class FightController {

    private final AdventureRepository fightDao;

    public FightController (AdventureRepository postDao){
        this.fightDao = postDao;
    }

    @GetMapping("/adventures/{id}/fight")
    public String fight(@PathVariable long id, Model model){
        model.addAttribute("adventure", fightDao.findOne(id));
        return "fight";
    }
}
