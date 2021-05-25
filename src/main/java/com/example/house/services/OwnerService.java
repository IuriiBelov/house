package com.example.house.services;

import com.example.house.entities.Owner;
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

    public List<Owner> getAllOwners() {
        List<Owner> allOwners = ownerRepository.findAll();
        return allOwners;
    }

    public Owner getOwnerById(String id) {
        Owner owner = ownerRepository.getOneById(Long.parseLong(id));
        return owner;
    }
}
