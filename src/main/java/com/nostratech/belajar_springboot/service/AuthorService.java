package com.nostratech.belajar_springboot.service;

import com.nostratech.belajar_springboot.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    public void saveAuthor(AuthorDTO authorDTO);

    public List<AuthorDTO> getAllAuthors();
}
