package com.nostratech.belajar_springboot.controller;

import com.nostratech.belajar_springboot.dto.AuthorDTO;
import com.nostratech.belajar_springboot.helper.BreadCrumbItem;
import com.nostratech.belajar_springboot.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("new")
    public String getMethodName(Model model) {
        model.addAttribute("authorDTO", new AuthorDTO(null, null));
        model.addAttribute("breadcrumb", List.of(
                new BreadCrumbItem("Home", "/authors/list"),
                new BreadCrumbItem("Author Create", "/authors/new")));
        return "author/create-author";
    }


    @PostMapping("new")
    public String postMethodName(@ModelAttribute AuthorDTO authorDTO, Model model, RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute("authorDTO", authorDTO);
        this.authorService.saveAuthor(authorDTO);

        return "redirect:/authors/result";
    }



    @GetMapping("result")
    public String displayResult(@ModelAttribute AuthorDTO authorDTO, Model model) {

        model.addAttribute("authorDTO", authorDTO);
        model.addAttribute("breadcrumb", List.of(
                new BreadCrumbItem("Home", "/authors/list"),
                new BreadCrumbItem("Author Create", "/authors/new"),
                new BreadCrumbItem("Result", "/authors/result")));
        return "author/author-result";
    }

    @GetMapping("list")
    public String getListAuthor(Model model) {

        List<AuthorDTO> authors = this.authorService.getAllAuthors();

        model.addAttribute("authors", authors);
        model.addAttribute("breadcrumb", List.of(
                new BreadCrumbItem("Home", "/authors/list"),
                new BreadCrumbItem("Author List", "/authors/list")));
        return "author/author-list";
    }
}
