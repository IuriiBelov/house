package com.example.house.controller;

import com.example.house.dto.BillDto;
import com.example.house.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bills")
@CrossOrigin(origins = {"http://localhost:4200"})
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public ResponseEntity<List<BillDto>> getAllBills(@RequestParam("page") int page,
                                                             @RequestParam("size") int size) {
        return new ResponseEntity<>(billService.getAllBills(page, size), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BillDto> getBillById(@PathVariable Long id) {
        return new ResponseEntity<>(billService.getBillById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BillDto> createNewBill(@RequestBody BillDto newBillDto)
            throws IllegalArgumentException {
        return new ResponseEntity<>(billService.createNewBill(newBillDto), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<BillDto> updateBillById(@PathVariable Long id,
                                                      @RequestBody BillDto billDto) {
        return new ResponseEntity<>(billService.updateBillById(id, billDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BillDto> deleteBillById(@PathVariable Long id) {
        return new ResponseEntity<>(billService.deleteBillById(id), HttpStatus.OK);
    }
}
