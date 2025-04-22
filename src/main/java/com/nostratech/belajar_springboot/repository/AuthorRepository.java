package com.nostratech.belajar_springboot.repository;

import com.nostratech.belajar_springboot.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
