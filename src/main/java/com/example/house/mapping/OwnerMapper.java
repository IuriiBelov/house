package com.example.house.mapping;

import com.example.house.dto.OwnerDto;
import com.example.house.entity.OwnerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerDto entityToDto(OwnerEntity entity);

    OwnerEntity dtoToEntity(OwnerDto dto);
}
