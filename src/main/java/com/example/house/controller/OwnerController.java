package com.example.house.controller;

import com.example.house.dto.OwnerDto;
import com.example.house.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OwnerController {

    private final OwnerService ownerService;

    private Logger LOGGER = LoggerFactory.getLogger("logger");

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
        LOGGER.info("Id: " + newOwnerDto.getId());
        LOGGER.info("Name: " + newOwnerDto.getName());
        LOGGER.info("Phone number: " + newOwnerDto.getPhoneNumber());
        LOGGER.info("Flats: " + newOwnerDto.getFlatsNumbers());
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
