package com.nostratech.belajar_springboot.controller;

import com.nostratech.belajar_springboot.dto.AuthorDTO;
import com.nostratech.belajar_springboot.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/v1/authors")
public class ApiAuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> addAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        this.authorService.saveAuthor(authorDTO);
        return ResponseEntity.created(URI.create("")).build();
    }
}
