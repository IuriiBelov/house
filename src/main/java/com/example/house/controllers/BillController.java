package com.example.house.controllers;

import com.example.house.entities.Bill;
import com.example.house.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bills")
public class BillController {
    private BillService billService;

    @Autowired
    public void setBillService(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public List<Bill> getAllBills() {
        List<Bill> allBills = billService.getAllBills();
        return allBills;
    }

    @GetMapping("{id}")
    public Bill getBillById(@PathVariable String id) {
        Bill bill = billService.getBillById(id);
        return bill;
    }
}
