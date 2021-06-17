package com.example.house.controller;

import com.example.house.dto.OwnerDto;
import com.example.house.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerDto> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("{id}")
    public OwnerDto getOwnerById(@PathVariable Long id) {
        return ownerService.getOwnerById(id);
    }

    @PostMapping
    public OwnerDto createNewOwner(@RequestBody OwnerDto newOwnerDto) {
        ownerService.createNewOwner(newOwnerDto);
        return newOwnerDto;
    }

    @PutMapping("{id}")
    public OwnerDto updateOwner(@PathVariable Long id, @RequestBody OwnerDto ownerDto) {
        ownerService.updateOwner(id, ownerDto);
        return ownerDto;
    }

    @DeleteMapping("{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
    }
}
