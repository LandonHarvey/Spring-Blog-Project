package com.codeup.springcodeupproject.controllers;

import com.codeup.springcodeupproject.models.Post;
import com.codeup.springcodeupproject.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class PostController {

    private final PostRepository postDao;

    public PostController (PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("posts/{id}")
    public String show(@PathVariable long id, Model model){

        model.addAttribute("post", postDao.findOne(id));

        return "posts/show";
    }

    @GetMapping("posts/create")
    public String showForm(){
        return "posts/create";
    }

    @PostMapping("posts/create")
    public String create(
            @RequestParam(name = "title") String title,
            @RequestParam (name = "description") String description,
            @RequestParam (name = "imgURL") String imgUrl
        ){

        Post post = new Post(title,description,imgUrl);
        postDao.save(post);

        return "redirect:/";
    }
}
