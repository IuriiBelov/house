package com.example.house.controller;

import com.example.house.dto.BillDtoRequest;
import com.example.house.dto.BillDtoResponse;
import com.example.house.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<BillDtoResponse>> getAllBills(@RequestParam("page") int page,
                                                             @RequestParam("size") int size) {
        return new ResponseEntity<>(billService.getAllBills(page, size), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BillDtoResponse> getBillById(@PathVariable Long id) {
        return new ResponseEntity<>(billService.getBillById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BillDtoResponse> createNewBill(@RequestBody BillDtoRequest newBillDto) {
        return new ResponseEntity<>(billService.createNewBill(newBillDto), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<BillDtoResponse> updateBill(@PathVariable Long id,
                                                      @RequestBody BillDtoRequest billDto) {
        return new ResponseEntity<>(billService.updateBill(id, billDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BillDtoResponse> deleteBill(@PathVariable Long id) {
        return new ResponseEntity<>(billService.deleteBill(id), HttpStatus.OK);
    }
}
