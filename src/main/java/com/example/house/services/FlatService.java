package com.example.house.services;

import com.example.house.entities.FlatEntity;
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

    public List<FlatEntity> getAllFlats() {
        List<FlatEntity> allFlatEntities = flatRepository.findAll();
        return allFlatEntities;
    }

    public FlatEntity getFlatById(String id) {
        FlatEntity flatEntity = flatRepository.getOneById(Long.parseLong(id));
        return flatEntity;
    }
}
