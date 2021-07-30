package com.example.house.utils.mapping;

import com.example.house.dto.BlockDtoResponse;
import com.example.house.entity.BlockEntity;
import com.example.house.entity.FlatEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BlockMapping {

    public BlockDtoResponse mapToDto(BlockEntity blockEntity) {
        BlockDtoResponse blockDtoResponse = new BlockDtoResponse();

        blockDtoResponse.setId(blockEntity.getId());
        blockDtoResponse.setNumber(blockEntity.getNumber());
        blockDtoResponse.setFlatsNumbers(blockEntity
                .getFlatEntities()
                .stream()
                .map(FlatEntity::getNumber)
                .collect(Collectors.toList()));

        return blockDtoResponse;
    }
}
