package com.example.house.mapping;

import com.example.house.dto.BillDto;
import com.example.house.entity.BillEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    BillDto entityToDto(BillEntity entity);

    BillEntity dtoToEntity(BillDto dto);
}
