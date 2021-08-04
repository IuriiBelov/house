package com.example.house.controller;

import com.example.house.dto.BillDto;
import com.example.house.dto.FlatDto;
import com.example.house.dto.OwnerDto;
import com.example.house.service.FlatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("flats")
public class FlatController {

    private final FlatService flatService;

    //private Logger LOGGER = LoggerFactory.getLogger("logger");

    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @GetMapping
    public ResponseEntity<List<FlatDto>> getAllFlats(@RequestParam("page") int page,
                                                     @RequestParam("size") int size) {
        return new ResponseEntity<>(flatService.getAllFlats(page, size), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<FlatDto> getFlatById(@PathVariable Long id) {
        return new ResponseEntity<>(flatService.getFlatById(id), HttpStatus.OK);
    }

    @GetMapping("{id}/bills")
    public ResponseEntity<List<BillDto>> getFlatBills(@PathVariable Long id) {
        return new ResponseEntity<>(flatService.getFlatBillsById(id), HttpStatus.OK);
    }

    @GetMapping("{id}/owners")
    public ResponseEntity<List<OwnerDto>> getFlatOwners(@PathVariable Long id) {
        return new ResponseEntity<>(flatService.getFlatOwnersById(id), HttpStatus.OK);
    }
}
