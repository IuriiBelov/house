package com.example.house.controllers;

import com.example.house.entities.Block;
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
    public List<Block> getAllBlocks() {
        List<Block> blocks = blockService.getAllBlocks();
        return blocks;
    }

    @GetMapping("{id}")
    public Block getBlockById(@PathVariable String id) {
        Block block = blockService.getBlockById(id);
        return block;
    }
}
