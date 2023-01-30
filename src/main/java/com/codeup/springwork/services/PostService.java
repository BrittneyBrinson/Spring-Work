package com.codeup.springwork.services;

import com.codeup.springwork.models.Post;
import com.codeup.springwork.models.User;
import com.codeup.springwork.repositories.PostRepository;
import com.codeup.springwork.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private final EmailService emailService;

    public PostService(PostRepository postRepo, UserRepository userRepo, EmailService emailService){
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    public void createPost(Post post){


    }
}
