package com.example.house.controllers;

import com.example.house.dtos.BillDto;
import com.example.house.dtos.FlatDto;
import com.example.house.dtos.OwnerDto;
import com.example.house.services.impl.FlatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("flats")
public class FlatController {
    private FlatServiceImpl flatServiceImpl;

    @Autowired
    public void setFlatService(FlatServiceImpl flatServiceImpl) {
        this.flatServiceImpl = flatServiceImpl;
    }

    @GetMapping
    public List<FlatDto> getAllFlats() {
        List<FlatDto> flatDtos = flatServiceImpl.getAllFlats();
        return flatDtos;
    }

    @GetMapping("{id}")
    public FlatDto getFlatById(@PathVariable String id) {
        FlatDto flatDto = flatServiceImpl.getFlatById(id);
        return flatDto;
    }

    @GetMapping("{id}/bills")
    public List<BillDto> getFlatBills(@PathVariable String id) {
        List<BillDto> flatBillDtos = flatServiceImpl.getFlatBillsById(id);
        return flatBillDtos;
    }

    @GetMapping("{id}/owners")
    public List<OwnerDto> getFlatOwners(@PathVariable String id) {
        List<OwnerDto> flatOwnerDtos = flatServiceImpl.getFlatOwnersById(id);
        return flatOwnerDtos;
    }
}
