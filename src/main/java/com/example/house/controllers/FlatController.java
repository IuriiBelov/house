package com.example.house.controllers;

import com.example.house.entities.Flat;
import com.example.house.repositories.FlatRepository;
import com.example.house.services.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("flats")
public class FlatController {
    private FlatService flatService;

    @Autowired
    public void setFlatService(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping
    public List<Flat> getAllFlats() {
        List<Flat> flats = flatService.getAllFlats();
        return flats;
    }

    @GetMapping("{id}")
    public Flat getFlatById(@PathVariable String id) {
        Flat flat = flatService.getFlatById(id);
        return flat;
    }
}
