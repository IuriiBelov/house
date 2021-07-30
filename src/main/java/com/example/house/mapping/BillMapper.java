package com.example.house.mapping;

import com.example.house.dto.BillDtoResponse;
import com.example.house.entity.BillEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    BillDtoResponse entityToDto(BillEntity entity);

    BillEntity dtoToEntity(BillDtoResponse dto);
}
