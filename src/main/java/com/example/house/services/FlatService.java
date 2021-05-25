package com.example.house.services;

import com.example.house.entities.Flat;
import com.example.house.repositories.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatService {
    private FlatRepository flatRepository;

    @Autowired
    public void setFlatRepository(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    public List<Flat> getAllFlats() {
        List<Flat> allFlats = flatRepository.findAll();
        return allFlats;
    }

    public Flat getFlatById(String id) {
        Flat flat = flatRepository.getOneById(Long.parseLong(id));
        return flat;
    }
}
