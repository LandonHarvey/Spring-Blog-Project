package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.repositories.AdventureRepository;
import com.codeup.springcodeupproject.repositories.OrcRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class FightController {

    private final AdventureRepository fightDao;
    private final OrcRepository orcDao;

    public FightController (AdventureRepository postDao, OrcRepository orcDao){
        this.fightDao = postDao;
        this.orcDao = orcDao;
    }

    @GetMapping("/adventures/{id}/fight")
    public String fight(@PathVariable long id, Model model){
        model.addAttribute("adventure", fightDao.findOne(id));
        return "fight";
    }
}
