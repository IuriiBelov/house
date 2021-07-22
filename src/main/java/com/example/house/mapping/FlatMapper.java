package com.example.house.mapping;

import com.example.house.dto.FlatDto;
import com.example.house.entity.FlatEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlatMapper {

    FlatDto entityToDto(FlatEntity entity);

    FlatEntity dtoToEntity(FlatDto dto);
}
