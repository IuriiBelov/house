package com.example.house.utils.mappings.impl;

import com.example.house.dtos.OwnerDto;
import com.example.house.entities.OwnerEntity;
import com.example.house.utils.mappings.Mapping;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapping implements Mapping<OwnerEntity, OwnerDto> {

    @Override
    public OwnerDto mapToDto(OwnerEntity entity) {
        return null;
    }

    @Override
    public OwnerEntity mapToEntity(OwnerDto dto) {
        return null;
    }
}
