package com.example.house.utils.mapping;

import com.example.house.dto.BlockDto;
import com.example.house.entity.BlockEntity;
import com.example.house.entity.FlatEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BlockMapping {

    public BlockDto mapToDto(BlockEntity blockEntity) {
        BlockDto blockDto = new BlockDto();

        blockDto.setId(blockEntity.getId());
        blockDto.setNumber(blockEntity.getNumber());
        blockDto.setFlatsNumbers(blockEntity
                .getFlatEntities()
                .stream()
                .map(FlatEntity::getNumber)
                .collect(Collectors.toList()));

        return blockDto;
    }
}
