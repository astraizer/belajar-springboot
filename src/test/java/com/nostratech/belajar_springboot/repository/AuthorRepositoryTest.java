package com.nostratech.belajar_springboot.repository;

import com.nostratech.belajar_springboot.model.Author;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorRepositoryTest {

    @Inject
    AuthorRepository authorRepository;

    @Test
    void saveAuthor(){
        Author author = new Author();
        author.setName("Kevin");
        author.setDesription("Penulis");

        authorRepository.save(author);
    }
}
