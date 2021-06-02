package com.example.house.controller;

import com.example.house.dto.BlockDto;
import com.example.house.dto.FlatDto;
import com.example.house.service.BlockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("blocks")
public class BlockController {

    private BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @GetMapping
    public List<BlockDto> getAllBlocks() {
        List<BlockDto> blockDtos = blockService.getAllBlocks();
        return blockDtos;
    }

    @GetMapping("{id}")
    public BlockDto getBlockById(@PathVariable String id) {
        BlockDto blockDto = blockService.getBlockById(id);
        return blockDto;
    }

    @GetMapping("{id}/flats")
    public List<FlatDto> getBlockFlats(@PathVariable String id) {
        List<FlatDto> blockFlatDtos = blockService.getBlockFlatsById(id);
        return blockFlatDtos;
    }
}
