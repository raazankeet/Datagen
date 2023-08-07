package com.ankit.raj.datagen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @GetMapping("/datagenerator")
    public String index() {
        return "index.html";
    }
}
