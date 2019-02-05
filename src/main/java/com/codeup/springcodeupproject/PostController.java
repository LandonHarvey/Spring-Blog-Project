package com.codeup.springcodeupproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class PostController {

    @GetMapping("/posts}")
    @ResponseBody
    public String indexPage(){
        return "All Posts";
    }

    @GetMapping("/posts/{id}}")
    @ResponseBody
    public String individualPost(@PathVariable int id){
        return "Post" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPage(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPagePost(){
        return "create a new post";
    }
}
