package com.example.house.controller;

import com.example.house.dto.BillDto;
import com.example.house.dto.FlatDto;
import com.example.house.dto.OwnerDto;
import com.example.house.service.FlatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("flats")
public class FlatController {

    private final FlatService flatService;

    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping
    public List<FlatDto> getAllFlats() {
        return flatService.getAllFlats();
    }

    @GetMapping("{id}")
    public FlatDto getFlatById(@PathVariable Long id) {
        return flatService.getFlatById(id);
    }

    @GetMapping("{id}/bills")
    public List<BillDto> getFlatBills(@PathVariable Long id) {
        return flatService.getFlatBillsById(id);
    }

    @GetMapping("{id}/owners")
    public List<OwnerDto> getFlatOwners(@PathVariable Long id) {
        return flatService.getFlatOwnersById(id);
    }
}
