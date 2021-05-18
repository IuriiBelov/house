package com.example.house.controllers;

import com.example.house.entities.Flat;
import com.example.house.services.FlatService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HouseController {
    private FlatService flatService;

    @Autowired
    public void setFlatService(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping("/index")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/flats")
    public String allFlatsPage(Model model) {
        List<Flat> allFlats = flatService.getAllFlats();
        model.addAttribute("flats", allFlats);
        return "flats";
    }

    /*
    @PostConstruct
    public void fillDatabase() {
        SessionFactory sessionFactory = new Configuration().buildSessionFactory();

        sessionFactory.close();
    }
     */
}
