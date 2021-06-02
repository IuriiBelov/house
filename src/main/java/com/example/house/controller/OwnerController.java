package com.example.house.controller;

import com.example.house.dto.OwnerDto;
import com.example.house.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerDto> getAllOwners() {
        List<OwnerDto> allOwnerDtos = ownerService.getAllOwners();
        return allOwnerDtos;
    }

    @GetMapping("{id}")
    public OwnerDto getOwnerById(@PathVariable String id) {
        OwnerDto ownerDto = ownerService.getOwnerById(id);
        return ownerDto;
    }

    @PostMapping
    public OwnerDto createNewOwner(@RequestBody OwnerDto newOwnerDto) {
        ownerService.createNewOwner(newOwnerDto);
        return newOwnerDto;
    }

    @PutMapping("{id}")
    public OwnerDto updateOwner(@PathVariable String id, @RequestBody OwnerDto ownerDto) {
        ownerService.updateOwner(id, ownerDto);
        return ownerDto;
    }

    @DeleteMapping("{id}")
    public void deleteOwner(@PathVariable String id) {
        ownerService.deleteOwner(id);
    }
}
