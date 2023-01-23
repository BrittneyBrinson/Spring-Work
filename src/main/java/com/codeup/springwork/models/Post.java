package com.codeup.springwork.models;
import com.codeup.springwork.repositories.PostRepository;

import javax.persistence.*;



@Entity
public class Post {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private String body;

    @OneToOne
    private User user;



    public Post(PostRepository postRepo) {
        this.title = title;
        this.body = body;

    }

    public Post() {

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


}
