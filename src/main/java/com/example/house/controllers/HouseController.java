package com.example.house.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HouseController {

    @GetMapping("/index")
    public String mainPage() {
        return "index";
    }
}
