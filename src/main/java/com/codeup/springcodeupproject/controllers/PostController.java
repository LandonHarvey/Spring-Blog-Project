package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.models.Adventure;
import com.codeup.springcodeupproject.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {

    private final PostRepository postDao;

    public PostController (PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("posts/{id}")
    public String show(@PathVariable long id, Model model){

        model.addAttribute("adventure", postDao.findOne(id));

        return "posts/show";
    }

    @GetMapping("create")
    public String showForm(Model model){
        model.addAttribute("adventure", new Adventure());
        return "posts/create";
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

    @PostMapping("/posts/{id}/save")
    public String savePosition(
            @PathVariable long id,
            @RequestParam(name = "position") long position
    ){
        Adventure adventure = postDao.findOne(id);
        adventure.setPostion(position);
        postDao.save(adventure);
        return "redirect:/posts/{id}";
    }

    @PostMapping("/posts/{id}/saveb4")
    public String savePositionb4(
            @PathVariable long id,
            @RequestParam(name = "position") long position
    ){
        Adventure adventure = postDao.findOne(id);
        adventure.setPostion(position);
        postDao.save(adventure);
        return "redirect:/posts/{id}/fight";
    }

    @GetMapping("/posts/{id}/fight")
    public String fight(@PathVariable long id, Model model){
        model.addAttribute("adventure", postDao.findOne(id));
        return "fight";
    }
}
