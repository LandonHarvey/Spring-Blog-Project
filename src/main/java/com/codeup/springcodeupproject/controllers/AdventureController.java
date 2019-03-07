package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.models.*;
import com.codeup.springcodeupproject.repositories.AdventureRepository;
import com.codeup.springcodeupproject.repositories.AdventurerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class AdventureController {

    private final AdventureRepository advDao;
    private final AdventurerRepository advrDao;

    public AdventureController(AdventureRepository advDao, AdventurerRepository advrDao){
        this.advDao = advDao;
        this.advrDao = advrDao;
    }

    @GetMapping("adventures/{id}")
    public String show(@PathVariable long id, Model model){
//
//        List<Adventurer> adventurers = advrDao.getAllAdventurerById(id);
        Adventure adventure = advDao.findOne(id);
        System.out.println("Adventurer List: " +adventure.getAdventurerList());

        model.addAttribute("adventure", adventure);
        return "adventures/show";
    }

    @GetMapping("create")
//    public String showForm(Model model){
    public String showForm(Model model){
        model.addAttribute("adventurer1", new Adventurer());
        model.addAttribute("adventurer2", new Adventurer());
        model.addAttribute("adventure", new Adventure());
        return "adventures/create";
    }

    // create a full adventure
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

        // creates adventure
        Adventure adventure = new Adventure(title, body, imgUrl);

        //Creates list of adventurers
        List<Adventurer> adventurerList = new ArrayList<>();

        // Creates Adventurers or Singular
        Adventurer adventurer = new Adventurer(name1, imgUrl1);
        adventurerList.add(adventurer);

        //Checks if a second player will join party
        if (!name2.equals("")) {
            Adventurer adventurer2 = new Adventurer(name2, imgUrl2);
            adventurerList.add(adventurer2);
            adventure.setAdventurerList(adventurerList);
            advDao.save(adventure);
            return "redirect:/";
        }

        adventure.setAdventurerList(adventurerList);
        advDao.save(adventure);
        return "redirect:/";
    }

    @GetMapping("adventures/{id}/fight")
    public String fight(@PathVariable long id){
        return "fight";
    }

    // posts save when save progress button clicked
    @PostMapping("/adventures/{id}/save")
    public String savePosition(
            @PathVariable long id,
            @RequestParam(name = "position") long position
    ){
        Adventure adventure = advDao.findOne(id);
        adventure.setPosition(position);
        advDao.save(adventure);
        return "redirect:/adventures/{id}";
    }

    // posts save when battle begins
    @PostMapping("/adventures/{id}/saveb4")
    public String savePositionb4(
            @PathVariable long id,
            @RequestParam(name = "position") long position
    ){
        Adventure adventure = advDao.findOne(id);
        adventure.setPosition(position);
        advDao.save(adventure);
        return "redirect:/adventures/{id}/fight";
    }

    @PostMapping("/adventures/{id}/delete")
    public String delete(@PathVariable long id){
        advDao.delete(id);
        return "redirect:/";
    }
}