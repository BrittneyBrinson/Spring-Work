package com.codeup.springwork;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class Post {
    private String title;
    private String body;

    public Post() {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @GetMapping("/show")
    public String showPost(Model model){
        Post newPost = new Post();
        newPost.setTitle("Anyways, life is great");
        newPost.setBody("Great things are happening for me");
        model.addAttribute("title",newPost.getTitle());
        model.addAttribute("body", newPost.getBody());
        return "posts/show";
    }

    @GetMapping("/showAll")
    public String showAllPosts(Model model){
        Post postOne = new Post();
        postOne.setTitle("I'm going to Denver next week");
        postOne.setBody("It's going to be soo much fun");
        Post postTwo = new Post();
        postTwo.setTitle("Mental Health Matters");
        postTwo.setBody("Always take care of your mental and physical health");
        ArrayList <Post> postList = new ArrayList<Post>();
        postList.add(postOne);
        postList.add(postTwo);
        model.addAttribute("title", postList);

        return "posts/index";
    }
}
