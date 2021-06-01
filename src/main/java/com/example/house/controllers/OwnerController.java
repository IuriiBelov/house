package com.example.house.controllers;

import com.example.house.dtos.OwnerDto;
import com.example.house.services.impl.OwnerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
public class OwnerController {

    private OwnerServiceImpl ownerServiceImpl;

    public void setOwnerService(OwnerServiceImpl ownerServiceImpl) {
        this.ownerServiceImpl = ownerServiceImpl;
    }

    @GetMapping
    public List<OwnerDto> getAllOwners() {
        List<OwnerDto> allOwnerDtos = ownerServiceImpl.getAllOwners();
        return allOwnerDtos;
    }

    @GetMapping("{id}")
    public OwnerDto getOwnerById(@PathVariable String id) {
        OwnerDto ownerDto = ownerServiceImpl.getOwnerById(id);
        return ownerDto;
    }

    @PostMapping
    public OwnerDto createNewOwner(@RequestBody OwnerDto newOwnerDto) {
        ownerServiceImpl.createNewOwner(newOwnerDto);
        return newOwnerDto;
    }

    @PutMapping("{id}")
    public OwnerDto updateOwner(@PathVariable String id, @RequestBody OwnerDto ownerDto) {
        ownerServiceImpl.updateOwner(id, ownerDto);
        return ownerDto;
    }

    @DeleteMapping("{id}")
    public void deleteOwner(@PathVariable String id) {
        ownerServiceImpl.deleteOwner(id);
    }
}
