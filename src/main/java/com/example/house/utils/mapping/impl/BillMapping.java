package com.example.house.utils.mapping.impl;

import com.example.house.dto.BillDto;
import com.example.house.entity.BillEntity;
import com.example.house.repository.FlatRepository;
import com.example.house.utils.mapping.Mapping;
import org.springframework.stereotype.Service;

@Service
public class BillMapping implements Mapping<BillEntity, BillDto> {

    private FlatRepository flatRepository;

    public BillMapping(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    @Override
    public BillDto mapToDto(BillEntity entity) {
        BillDto dto = new BillDto();

        dto.setId(entity.getId());
        dto.setFlatId(entity.getBillFlat().getId());
        dto.setDate(entity.getDate());
        dto.setBillStatus(entity.getBillStatus());

        return dto;
    }

    @Override
    public BillEntity mapToEntity(BillDto dto) {
        BillEntity entity = new BillEntity();

        entity.setId(dto.getId());
        entity.setBillFlat(flatRepository.getOneById(dto.getId()));
        entity.setDate(dto.getDate());
        entity.setBillStatus(dto.getBillStatus());

        return entity;
    }
}