package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.models.Adventure;
import com.codeup.springcodeupproject.models.AdventureLog;
import com.codeup.springcodeupproject.repositories.AdventureLogRepository;
import com.codeup.springcodeupproject.repositories.AdventureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class AdventureController {

    private final AdventureLogRepository adLogDao;

    public AdventureController(AdventureLogRepository adLogDao){
        this.adLogDao = adLogDao;
    }

    @GetMapping("adventures/{id}")
    public String show(@PathVariable long id, Model model){

        model.addAttribute("adventure", adLogDao.findOne(id));

        return "adventures/show";
    }

    @GetMapping("create")
    public String showForm(Model model){
        model.addAttribute("adventure", new Adventure());
        return "adventures/create";
    }

    @PostMapping("create")
    public String create(
            @RequestParam(name = "title") String title,
            @RequestParam (name = "body") String body,
            @RequestParam (name = "imgURL") String imgUrl
        ){

        Adventure adventure = new Adventure(title,body,imgUrl);
        postDao.save(adventure);

        return "redirect:/";
    }

    @PostMapping("/adventures/{id}/save")
    public String savePosition(
            @PathVariable long id,
            @RequestParam(name = "position") long position
    ){
        Adventure adventure = postDao.findOne(id);
//        adventure.setPostion(position);
        postDao.save(adventure);
        return "redirect:/adventures/{id}";
    }

    @PostMapping("/adventures/{id}/saveb4")
    public String savePositionb4(
            @PathVariable long id,
            @RequestParam(name = "position") long position
    ){
        Adventure adventure = postDao.findOne(id);
//        adventure.setPostion(position);
        postDao.save(adventure);
        return "redirect:/adventures/{id}/fight";
    }
}
