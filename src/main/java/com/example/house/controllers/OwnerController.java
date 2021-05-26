package com.example.house.controllers;

import com.example.house.entities.OwnerEntity;
import com.example.house.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
public class OwnerController {
    private OwnerService ownerService;

    @Autowired
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerEntity> getAllOwners() {
        List<OwnerEntity> allOwnerEntities = ownerService.getAllOwners();
        return allOwnerEntities;
    }

    @GetMapping("{id}")
    public OwnerEntity getOwnerById(@PathVariable String id) {
        OwnerEntity ownerEntity = ownerService.getOwnerById(id);
        return ownerEntity;
    }

    @PostMapping
    public OwnerEntity createNewOwner(@RequestBody OwnerEntity newOwnerEntity) {
        ownerService.createNewOwner(newOwnerEntity);
        return newOwnerEntity;
    }

    @PutMapping("{id}")
    public OwnerEntity updateOwner(@PathVariable String id, @RequestBody OwnerEntity ownerEntity) {
        ownerService.updateOwner(id, ownerEntity);
        return ownerEntity;
    }

    @DeleteMapping("{id")
    public void deleteOwner(@PathVariable String id) {
        ownerService.deleteOwner(id);
    }
}
