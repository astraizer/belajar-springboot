package com.nostratech.belajar_springboot.config;


import com.nostratech.belajar_springboot.model.Author;
import com.nostratech.belajar_springboot.model.Book;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@ComponentScan(basePackages = {"com.nostratech.belajar_springboot"})
@Configuration
public class AppConfig {

    @Bean
    public Author author(){
        Author author = new Author();
        author.setName("Test name 2");
        return author;
    }

    @Bean
    public Book book(Author author){
        return new Book("Testbook", author );
    }

    @Bean
    public Properties properties(){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        return properties;
    }

    @Bean
    public PasswordAuthentication passwordAuthentication(){
        return new PasswordAuthentication("username", "password");
    }

    @Bean
    public Session session(@Qualifier("properties") Properties properties, PasswordAuthentication passwordAuthentication){
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return passwordAuthentication;
            }
        });
    }
}
