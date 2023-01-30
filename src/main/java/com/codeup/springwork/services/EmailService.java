package com.codeup.springwork.services;

import com.codeup.springwork.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {


    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void sendEmail(Post post, String title, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(post.getUser().getEmail());
        message.setSubject(title);
        message.setText(body);

        try{
            this.emailSender.send(message);
        }catch(MailException error){
            System.out.println(error.getMessage());
        }

    }
}
