package com.example.house.controllers;

import com.example.house.entities.BlockEntity;
import com.example.house.entities.FlatEntity;
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
    public List<BlockEntity> getAllBlocks() {
        List<BlockEntity> blockEntities = blockService.getAllBlocks();
        return blockEntities;
    }

    @GetMapping("{id}")
    public BlockEntity getBlockById(@PathVariable String id) {
        BlockEntity blockEntity = blockService.getBlockById(id);
        return blockEntity;
    }

    @GetMapping("{id}/flats")
    public List<FlatEntity> getBlockFlats(@PathVariable String id) {
        List<FlatEntity> blockFlatEntities = blockService.getBlockFlatsById(id);
        return blockFlatEntities;
    }
}
