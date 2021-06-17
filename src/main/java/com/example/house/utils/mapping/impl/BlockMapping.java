package com.example.house.utils.mapping.impl;

import com.example.house.dto.BlockDto;
import com.example.house.entity.BlockEntity;
import com.example.house.utils.mapping.Mapping;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BlockMapping implements Mapping<BlockEntity, BlockDto> {

    private final FlatMapping flatMapping;

    public BlockMapping(FlatMapping flatMapping) {
        this.flatMapping = flatMapping;
    }

    @Override
    public BlockDto mapToDto(BlockEntity entity) {
        BlockDto dto = new BlockDto();

        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setFlats(entity
                .getFlatEntities()
                .stream()
                .map(flatMapping::mapToDto)
                .collect(Collectors.toList()));

        return dto;
    }

    @Override
    public BlockEntity mapToEntity(BlockDto dto) {
        BlockEntity entity = new BlockEntity();

        entity.setId(dto.getId());
        entity.setNumber(dto.getNumber());
        entity.setFlatEntities(dto
                .getFlats()
                .stream()
                .map(flatMapping::mapToEntity)
                .collect(Collectors.toList()));

        return entity;
    }
}
