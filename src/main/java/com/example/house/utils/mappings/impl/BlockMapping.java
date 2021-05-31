package com.example.house.utils.mappings.impl;

import com.example.house.dtos.BlockDto;
import com.example.house.entities.BlockEntity;
import com.example.house.utils.mappings.Mapping;
import org.springframework.stereotype.Service;

@Service
public class BlockMapping implements Mapping<BlockEntity, BlockDto> {

    @Override
    public BlockDto mapToDto(BlockEntity entity) {
        return null;
    }

    @Override
    public BlockEntity mapToEntity(BlockDto dto) {
        return null;
    }
}
