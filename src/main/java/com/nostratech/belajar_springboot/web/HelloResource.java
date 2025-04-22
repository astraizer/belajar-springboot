package com.nostratech.belajar_springboot.web;

import com.nostratech.belajar_springboot.config.ApplicationProperties;
import com.nostratech.belajar_springboot.model.Author;
import com.nostratech.belajar_springboot.model.Book;
import com.nostratech.belajar_springboot.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloResource {

    private ApplicationProperties applicationProperties;

    private Book book;
    private Author author;
    private EmailService emailService;

    public HelloResource(ApplicationProperties applicationProperties, Book book, Author author, EmailService emailService) {
        this.applicationProperties = applicationProperties;
        this.book = book;
        this.author = author;
        this.emailService = emailService;
    }

    @GetMapping
    public String hello() {
        return "Hello World "+applicationProperties.getName() +" ,"+applicationProperties.getCurrency();
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
