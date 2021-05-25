package com.example.house.controllers;

import com.example.house.entities.Owner;
import com.example.house.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("owners")
public class OwnerController {
    private OwnerService ownerService;

    @Autowired
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping
    public List<Owner> getAllOwners() {
        List<Owner> allOwners = ownerService.getAllOwners();
        return allOwners;
    }

    @RequestMapping("{id}")
    public Owner getOwnerById(@PathVariable String id) {
        Owner owner = ownerService.getOwnerById(id);
        return owner;
    }
}
