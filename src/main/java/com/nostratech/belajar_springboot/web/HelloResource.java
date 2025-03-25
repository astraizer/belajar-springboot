package com.nostratech.belajar_springboot.web;

import com.nostratech.belajar_springboot.model.Author;
import com.nostratech.belajar_springboot.model.Book;
import com.nostratech.belajar_springboot.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloResource {

    @Value("${test.name}")
    private String name;

    @Autowired
    private Book book;

    @Autowired
    private Author author;

    @Autowired
    private EmailService emailService;

    @GetMapping
    public String hello() {
        return "Hello "+name;
    }

    @GetMapping("/book")
    public String helloBook() {
        return "Hello "+book.getTitle();
    }

    @GetMapping("/author")
    public String helloAuthor() {
        return "Hello "+author.getName();
    }

    @GetMapping("/send-message")
    public String sendMessage(){
        try {
            emailService.sendMessage();
            return "OK";
        }catch (Exception e){
            return e.getLocalizedMessage();
        }
    }
}
