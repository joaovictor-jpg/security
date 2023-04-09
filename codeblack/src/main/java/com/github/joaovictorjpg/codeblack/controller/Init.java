package com.github.joaovictorjpg.codeblack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Init {
    @GetMapping
    public String Init() {
        return "Hello World";
    }
}
