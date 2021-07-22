package com.example.house.controller;

import com.example.house.dto.BillDto;
import com.example.house.service.BillService;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("bills")
public class BillController {

    private final BillService billService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public List<BillDto> getAllBills() {
        LOGGER.info("all bills");
        return billService.getAllBills();
    }

    @GetMapping("{id}")
    public BillDto getBillById(@PathVariable Long id) {
        return billService.getBillById(id);
    }

    @PostMapping
    public BillDto createNewBill(@RequestBody BillDto newBillDto) {
        LOGGER.info("create");
        return billService.createNewBill(newBillDto);
    }

    @PutMapping("{id}")
    public BillDto updateBill(@PathVariable Long id, @RequestBody BillDto billDto) {
        LOGGER.info("update");
        return billService.updateBill(id, billDto);
    }

    @DeleteMapping("{id}")
    public void deleteBill(@PathVariable Long id) {
        LOGGER.info("delete");
        billService.deleteBill(id);
    }
}
