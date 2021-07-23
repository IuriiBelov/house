package com.example.house.controller;

import com.example.house.dto.BlockDto;
import com.example.house.dto.FlatDto;
import com.example.house.service.BlockService;
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
    public List<BlockDto> getAllBlocks(@RequestParam("page") int page,
                                       @RequestParam("size") int size) {
        return blockService.getAllBlocks(page, size);
    }

    @GetMapping("{id}")
    public BlockDto getBlockById(@PathVariable Long id) {
        return blockService.getBlockById(id);
    }

    @GetMapping("{id}/flats")
    public List<FlatDto> getBlockFlats(@PathVariable Long id) {
        return blockService.getBlockFlatsById(id);
    }
}
