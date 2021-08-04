package com.example.house.controller;

import com.example.house.dto.OwnerDto;
import com.example.house.entity.converter.OwnerName;
import com.example.house.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<OwnerDto>> getAllOwners(@RequestParam("page") int page,
                                                       @RequestParam("size") int size) {
        return new ResponseEntity<>(ownerService.getAllOwners(page, size), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<OwnerDto> getOwnerById(@PathVariable Long id) {
        return new ResponseEntity<>(ownerService.getOwnerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OwnerDto> createNewOwner(@RequestBody OwnerDto newOwnerDto) {
        OwnerDto ownerDto = ownerService
                .createNewOwner(newOwnerDto)
                .orElseThrow(IllegalStateException::new);
        return new ResponseEntity<>(ownerDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<OwnerDto> updateOwnerById(@PathVariable Long id,
                                                    @RequestBody OwnerDto ownerDto) {
        return new ResponseEntity<>(ownerService.updateOwnerById(id, ownerDto),
                HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<OwnerDto> deleteOwnerById(@PathVariable Long id) {
        return new ResponseEntity<>(ownerService.deleteOwnerById(id), HttpStatus.OK);
    }
}
