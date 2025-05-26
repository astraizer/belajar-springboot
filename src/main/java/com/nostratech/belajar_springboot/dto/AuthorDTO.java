package com.nostratech.belajar_springboot.dto;

import com.nostratech.belajar_springboot.validation.annotation.ValidName;
import jakarta.validation.constraints.NotEmpty;


public record AuthorDTO(
        @NotEmpty
        @ValidName(message = "Name must not be admin")
        String name,
        String description) {
}