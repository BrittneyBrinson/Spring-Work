package com.codeup.springwork.controllers;

import com.codeup.springwork.models.Post;
import com.codeup.springwork.repositories.PostRepository;
import com.codeup.springwork.repositories.UserRepository;
import com.codeup.springwork.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;

@Controller
public class PostController {
    private final PostRepository postRepo;

    private final UserRepository userRepo;

    private final EmailService emailService;

    public PostController(PostRepository postRepo, UserRepository userRepo, EmailService emailService) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post newPost) {
        postRepo.save(newPost);
        return "redirect:/posts/index";
    }

    @GetMapping("/show")
    public String showPost(Model model) {
        Post newPost = new Post(postRepo);
        newPost.setTitle("Anyways, life is great");
        newPost.setBody("Great things are happening for me");
        model.addAttribute("title", newPost.getTitle());
        model.addAttribute("body", newPost.getBody());
        return "posts/show";
    }

    @GetMapping("/showAll")
    public String showAllPosts(Model model) {
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

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", new Post());
        return "posts/edit";
    }


}
