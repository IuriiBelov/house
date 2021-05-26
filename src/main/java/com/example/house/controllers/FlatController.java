package com.example.house.controllers;

import com.example.house.entities.FlatEntity;
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
    public List<FlatEntity> getAllFlats() {
        List<FlatEntity> flatEntities = flatService.getAllFlats();
        return flatEntities;
    }

    @GetMapping("{id}")
    public FlatEntity getFlatById(@PathVariable String id) {
        FlatEntity flatEntity = flatService.getFlatById(id);
        return flatEntity;
    }
}
