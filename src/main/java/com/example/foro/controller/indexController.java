package com.example.foro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    
    @GetMapping("/")
    public  String index (Model model)
    {
        model.addAttribute("titulo","Inicio");
        return "index";
    }
}
