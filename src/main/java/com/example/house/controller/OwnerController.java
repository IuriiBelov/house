package com.example.house.controller;

import com.example.house.dto.OwnerDtoRequest;
import com.example.house.dto.OwnerDtoResponse;
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
    public ResponseEntity<List<OwnerDtoResponse>> getAllOwners(@RequestParam("page") int page,
                                                               @RequestParam("size") int size) {
        return new ResponseEntity<>(ownerService.getAllOwners(page, size), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<OwnerDtoResponse> getOwnerById(@PathVariable Long id) {
        return new ResponseEntity<>(ownerService.getOwnerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OwnerDtoResponse> createNewOwner(@RequestBody OwnerDtoRequest newOwnerDto) {
        OwnerDtoResponse ownerDto = ownerService.createNewOwner(newOwnerDto).orElseThrow(IllegalStateException::new);
        return new ResponseEntity<>(ownerDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<OwnerDtoResponse> updateOwner(@PathVariable Long id, @RequestBody OwnerDtoRequest ownerDto) {
        return new ResponseEntity<>(ownerService.updateOwner(id, ownerDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<OwnerDtoResponse> deleteOwner(@PathVariable Long id) {
        return new ResponseEntity<>(ownerService.deleteOwner(id), HttpStatus.OK);
    }
}
