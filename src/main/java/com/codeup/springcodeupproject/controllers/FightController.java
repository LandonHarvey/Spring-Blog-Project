package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.models.Adventure;
import com.codeup.springcodeupproject.models.Adventurer;
import com.codeup.springcodeupproject.models.Orc;
import com.codeup.springcodeupproject.repositories.AdventureRepository;
import com.codeup.springcodeupproject.repositories.OrcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
class FightController {

    private final AdventureRepository fightDao;
    private final OrcRepository orcDao;

    public FightController (AdventureRepository postDao, OrcRepository orcDao){
        this.fightDao = postDao;
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

    @GetMapping("/adventures/{id}/fight")
    public String fight(@PathVariable long id, Model model){
        model.addAttribute("id", id);
//        long random = Math.round(Math.random() * (2) + 1);
//        List<Orc> orcs = new ArrayList<>();
//        for(int i = 0; i< random; i++){
//            long randomorc = Math.round(Math.random() * (3) + 1);
//            orcs.add(orcDao.findOne(randomorc));
//        }
//
//        model.addAttribute("orcs", orcs);
//        model.addAttribute("adventure", fightDao.findOne(id));
//        System.out.println(fightDao.findOne(id).getBody());

        return "fighttest";
    }
}
