package com.nostratech.belajar_springboot.service.impl;

import com.nostratech.belajar_springboot.dto.AuthorDTO;
import com.nostratech.belajar_springboot.model.Author;
import com.nostratech.belajar_springboot.repository.AuthorRepository;
import com.nostratech.belajar_springboot.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void saveAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.name());
        author.setDesription(authorDTO.description());
        authorRepository.save(author);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<AuthorDTO> authors = new ArrayList<>();
        List<Author> authorList = authorRepository.findAll();
        for (Author author : authorList) {
            authors.add(new AuthorDTO(author.getName(), author.getDesription()));
        }
        return authors;
    }
}
