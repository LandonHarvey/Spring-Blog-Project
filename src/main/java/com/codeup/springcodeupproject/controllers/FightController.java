package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.models.Adventure;
import com.codeup.springcodeupproject.models.Orc;
import com.codeup.springcodeupproject.repositories.AdventureRepository;
import com.codeup.springcodeupproject.repositories.OrcRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class FightController {

    private final AdventureRepository fightDao;
    private final OrcRepository orcDao;

    public FightController (AdventureRepository fightDao, OrcRepository orcDao){
        this.fightDao = fightDao;
        this.orcDao = orcDao;
    }

    @GetMapping("/{id}/fight.json")
    public @ResponseBody  Adventure viewFullFight(@PathVariable() long id){

        return fightDao.findOne(id);
    }

    @GetMapping("/orc.json")
    public @ResponseBody  List<Orc> viewOrcFight(){
        List<Orc> orcs = new ArrayList<>();
        long random = Math.round(Math.random() * (2) + 1);
        for(int i = 0; i< random; i++){
            long randomorc = Math.round(Math.random() * (3) + 1);
            orcs.add(orcDao.findOne(randomorc));
        }
        return orcs;
    }

    @PostMapping("/adventures/{id}/fightwon")
    public String fightwon(@RequestBody Adventure adventure, @PathVariable String id){

        fightDao.save(adventure);
        return "redirect:/adventures/2";
    }
}
