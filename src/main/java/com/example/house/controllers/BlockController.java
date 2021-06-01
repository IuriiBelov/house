package com.example.house.controllers;

import com.example.house.dtos.BlockDto;
import com.example.house.dtos.FlatDto;
import com.example.house.services.impl.BlockServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("blocks")
public class BlockController {

    private BlockServiceImpl blockServiceImpl;

    public void setBlockService(BlockServiceImpl blockServiceImpl) {
        this.blockServiceImpl = blockServiceImpl;
    }

    @GetMapping
    public List<BlockDto> getAllBlocks() {
        List<BlockDto> blockDtos = blockServiceImpl.getAllBlocks();
        return blockDtos;
    }

    @GetMapping("{id}")
    public BlockDto getBlockById(@PathVariable String id) {
        BlockDto blockDto = blockServiceImpl.getBlockById(id);
        return blockDto;
    }

    @GetMapping("{id}/flats")
    public List<FlatDto> getBlockFlats(@PathVariable String id) {
        List<FlatDto> blockFlatDtos = blockServiceImpl.getBlockFlatsById(id);
        return blockFlatDtos;
    }
}
