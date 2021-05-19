package com.example.house.services;

import com.example.house.entities.Block;
import com.example.house.repositories.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {
    private BlockRepository blockRepository;

    @Autowired
    public void setBlockRepository(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }
}
