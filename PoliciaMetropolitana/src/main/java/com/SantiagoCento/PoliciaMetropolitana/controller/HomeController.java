package com.SantiagoCento.PoliciaMetropolitana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin/home")
    public String adminhome() {
        return "/admin/home";
    }

    @GetMapping("/investigador/home")
    public String investigadorhome() {
        return "/investigador/home";
    }

    @GetMapping("/")
    public String homeAlternativo() {
        return "home";
    }

    @GetMapping("/acercade")
    public String acercaDe() {
        return "acercade";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
