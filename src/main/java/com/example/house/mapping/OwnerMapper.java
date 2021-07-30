package com.example.house.mapping;

import com.example.house.dto.OwnerDtoResponse;
import com.example.house.entity.OwnerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerDtoResponse entityToDto(OwnerEntity entity);

    OwnerEntity dtoToEntity(OwnerDtoResponse dto);
}
