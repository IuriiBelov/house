package com.example.house.controller;

import com.example.house.dto.BillDto;
import com.example.house.dto.OwnerDto;
import com.example.house.service.BillService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public BillDto createNewBill(@RequestBody BillDto newBillDto) {
        billService.createNewBill(newBillDto);
        return newBillDto;
    }

    @PutMapping("{id}")
    public BillDto updateBill(@PathVariable Long id, @RequestBody BillDto billDto) {
        billService.updateBill(id, billDto);
        return billDto;
    }

    @DeleteMapping("{id}")
    public void deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
    }
}
