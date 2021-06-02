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

    private FlatService flatService;

    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping
    public List<FlatDto> getAllFlats() {
        List<FlatDto> flatDtos = flatService.getAllFlats();
        return flatDtos;
    }

    @GetMapping("{id}")
    public FlatDto getFlatById(@PathVariable String id) {
        FlatDto flatDto = flatService.getFlatById(id);
        return flatDto;
    }

    @GetMapping("{id}/bills")
    public List<BillDto> getFlatBills(@PathVariable String id) {
        List<BillDto> flatBillDtos = flatService.getFlatBillsById(id);
        return flatBillDtos;
    }

    @GetMapping("{id}/owners")
    public List<OwnerDto> getFlatOwners(@PathVariable String id) {
        List<OwnerDto> flatOwnerDtos = flatService.getFlatOwnersById(id);
        return flatOwnerDtos;
    }
}
