package com.example.house.controllers;

import com.example.house.dtos.BlockDto;
import com.example.house.dtos.FlatDto;
import com.example.house.services.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("blocks")
public class BlockController {
    private BlockService blockService;

    @Autowired
    public void setBlockService(BlockService blockService) {
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
