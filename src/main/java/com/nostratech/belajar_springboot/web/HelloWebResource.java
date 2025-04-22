package com.nostratech.belajar_springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello-web")
public class HelloWebResource {

    @GetMapping
    public String hello() {
        return "Hello";
    }
}
