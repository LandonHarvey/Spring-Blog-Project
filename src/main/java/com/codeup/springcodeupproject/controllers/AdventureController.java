package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.models.Adventure;
import com.codeup.springcodeupproject.models.AdventureLog;
import com.codeup.springcodeupproject.models.Adventurer;
import com.codeup.springcodeupproject.models.fullAdventure;
import com.codeup.springcodeupproject.repositories.AdventureLogRepository;
import com.codeup.springcodeupproject.repositories.AdventureRepository;
import com.codeup.springcodeupproject.repositories.AdventurerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
class AdventureController {

    private final AdventureLogRepository adLogDao;
    private final AdventureRepository advDao;
    private final AdventurerRepository advrDao;

    public AdventureController(AdventureLogRepository adLogDao, AdventureRepository advDao, AdventurerRepository advrDao){
        this.adLogDao = adLogDao;
        this.advDao = advDao;
        this.advrDao = advrDao;
    }

    @GetMapping("adventures/{id}")
    public String show(@PathVariable long id, Model model){

        List<Adventurer> adventurers = advrDao.getAllAdventurerById(id);
        Adventure adventure = advDao.getAdventureBy(id);
        AdventureLog adventureLog = adLogDao.findOne(id);

        fullAdventure fullAdventure = new fullAdventure(adventureLog, adventure, adventurers);

        model.addAttribute("adventure", fullAdventure);
        return "adventures/show";
    }

    @GetMapping("create")
//    public String showForm(Model model){
    public String showForm(Model model){
//        model.addAttribute("adventure", new Adventure());
//        model.addAttribute("adventurer", new Adventure());
//        model.addAttribute("adventure", new Adventure());
        return "adventures/create";
    }

    @PostMapping("create")
    public String create(
            @RequestParam(name = "title") String title,
            @RequestParam (name = "body") String body,
            @RequestParam (name = "imgURL") String imgUrl,

            @RequestParam(name = "name1") String name1,
            @RequestParam (name = "imgURL1") String imgUrl1,

            @RequestParam(name = "name2") String name2,
            @RequestParam (name = "imgURL2") String imgUrl2
        ){
//        Adventure adventure = new Adventure();
//        adLogDao.save(adventure);
//
////        long id, String title, String body, String imgURL, AdventureLogModel adventureLog
//        Adventure adventure = new Adventure(title, body, imgUrl, adventureLog);
//        Adventurer adventurer = new Adventurer(name1, imgUrl1, adventureLog);
//        if (name2.equals("")) {
//            Adventurer adventurer2 = new Adventurer(name2, imgUrl2, adventureLog);
//            advrDao.save(adventurer2);
//        }
//        advDao.save(adventure);
//        advrDao.save(adventurer);
//

        return "redirect:/";
    }

    @PostMapping("/adventures/{id}/save")
    public String savePosition(
            @PathVariable long id,
            @RequestParam(name = "position") long position
    ){
        AdventureLog adventureLog = adLogDao.findOne(id);
        adventureLog.setPostion(position);
        adLogDao.save(adventureLog);
        return "redirect:/adventures/{id}";
    }

    @PostMapping("/adventures/{id}/saveb4")
    public String savePositionb4(
            @PathVariable long id,
            @RequestParam(name = "position") long position
    ){
        AdventureLog adventureLog = adLogDao.findOne(id);
//        adventure.setPostion(position);
        adLogDao.save(adventureLog);
        return "redirect:/adventures/{id}/fight";
    }
}
