package com.example.house.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class HouseController {

    @GetMapping("/")
    public ResponseEntity<String> mainPage() {
        return new ResponseEntity<>("House", HttpStatus.OK);
    }
}
