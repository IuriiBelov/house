package com.example.house.services;

import com.example.house.entities.OwnerEntity;
import com.example.house.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private OwnerRepository ownerRepository;

    @Autowired
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<OwnerEntity> getAllOwners() {
        List<OwnerEntity> allOwnerEntities = ownerRepository.findAll();
        return allOwnerEntities;
    }

    public OwnerEntity getOwnerById(String id) {
        OwnerEntity ownerEntity = ownerRepository.getOneById(Long.parseLong(id));
        return ownerEntity;
    }

    public void createNewOwner(OwnerEntity newOwnerEntity) {
        ownerRepository.save(newOwnerEntity);
    }

    public void updateOwner(String id, OwnerEntity newOwnerEntity) {
        OwnerEntity oldOwnerEntity = ownerRepository.getOneById(Long.parseLong(id));
        if (oldOwnerEntity != null) {
            ownerRepository.save(newOwnerEntity);
        }
    }

    public void deleteOwner(String id) {
        ownerRepository.deleteById(Long.parseLong(id));
    }
}
