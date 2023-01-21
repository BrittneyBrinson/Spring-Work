package com.codeup.springwork.controllers;

import com.codeup.springwork.Post;
import com.codeup.springwork.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;

@Controller
public class PostController {
private final PostRepository postRepo;

    public PostController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping("/create")
    public String showCreateForm(){
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(String title,Model model){
        model.addAttribute("title", title);
                return "create";
    }

    @GetMapping("/show")
    public String showPost(Model model){
        Post newPost = new Post(postRepo);
        newPost.setTitle("Anyways, life is great");
        newPost.setBody("Great things are happening for me");
        model.addAttribute("title",newPost.getTitle());
        model.addAttribute("body", newPost.getBody());
        return "posts/show";
    }

    @GetMapping("/showAll")
    public String showAllPosts(Model model){
        Post postOne = new Post(postRepo);
        postOne.setTitle("I'm going to Denver next week");
        postOne.setBody("It's going to be soo much fun");
        Post postTwo = new Post(postRepo);
        postTwo.setTitle("Mental Health Matters");
        postTwo.setBody("Always take care of your mental and physical health");
        ArrayList<Post> postList = new ArrayList<Post>();
        postList.add(postOne);
        postList.add(postTwo);
        model.addAttribute("title", postList);

        return "posts/index";
    }


}
