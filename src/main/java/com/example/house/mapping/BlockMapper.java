package com.example.house.mapping;

import com.example.house.dto.BlockDto;
import com.example.house.entity.BlockEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlockMapper {

    BlockDto entityToDto(BlockEntity entity);

    BlockEntity dtoToEntity(BlockDto dto);
}
