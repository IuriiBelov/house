package com.example.house.controllers;

import com.example.house.dtos.BillDto;
import com.example.house.services.impl.BillServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bills")
public class BillController {

    private final BillServiceImpl billService;

    public BillController(BillServiceImpl billService) {
        this.billService = billService;
    }

    @GetMapping
    public List<BillDto> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("{id}")
    public BillDto getBillById(@PathVariable Long id) {
        return billService.getBillById(id);
    }
}
