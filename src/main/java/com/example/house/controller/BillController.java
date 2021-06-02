package com.example.house.controller;

import com.example.house.dto.BillDto;
import com.example.house.service.BillService;
import com.example.house.service.impl.BillServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
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
