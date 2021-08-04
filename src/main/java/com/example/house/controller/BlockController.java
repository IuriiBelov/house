package com.example.house.controller;

import com.example.house.dto.BlockDto;
import com.example.house.dto.FlatDto;
import com.example.house.service.BlockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("blocks")
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @GetMapping
    public ResponseEntity<List<BlockDto>> getAllBlocks(@RequestParam("page") int page,
                                                       @RequestParam("size") int size) {
        return new ResponseEntity<>(blockService.getAllBlocks(page, size), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BlockDto> getBlockById(@PathVariable Long id) {
        return new ResponseEntity<>(blockService.getBlockById(id), HttpStatus.OK);
    }

    @GetMapping("{id}/flats")
    public ResponseEntity<List<FlatDto>> getBlockFlatsById(@PathVariable Long id) {
        return new ResponseEntity<>(blockService.getBlockFlatsById(id), HttpStatus.OK);
    }
}
