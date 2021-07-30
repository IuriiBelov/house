package com.example.house.mapping;

import com.example.house.dto.FlatDtoResponse;
import com.example.house.entity.FlatEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlatMapper {

    FlatDtoResponse entityToDto(FlatEntity entity);

    FlatEntity dtoToEntity(FlatDtoResponse dto);
}
