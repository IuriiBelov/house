package com.example.house.services;

import com.example.house.entities.BlockEntity;
import com.example.house.entities.FlatEntity;
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

    public List<BlockEntity> getAllBlocks() {
        List<BlockEntity> allBlockEntities = blockRepository.findAll();
        return allBlockEntities;
    }

    public BlockEntity getBlockById(String id) {
        BlockEntity blockEntity = blockRepository.getOneById(Long.parseLong(id));
        return blockEntity;
    }

    public List<FlatEntity> getBlockFlatsById(String id) {
        List<FlatEntity> blockFlatEntities = blockRepository.getOneById(Long.parseLong(id)).getFlats();
        return blockFlatEntities;
    }
}
