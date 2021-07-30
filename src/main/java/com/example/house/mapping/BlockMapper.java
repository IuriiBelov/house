package com.example.house.mapping;

import com.example.house.dto.BlockDtoResponse;
import com.example.house.entity.BlockEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlockMapper {

    BlockDtoResponse entityToDto(BlockEntity entity);

    BlockEntity dtoToEntity(BlockDtoResponse dto);
}
