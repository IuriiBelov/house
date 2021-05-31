package com.example.house.utils.mappings.impl;

import com.example.house.dtos.FlatDto;
import com.example.house.entities.FlatEntity;
import com.example.house.utils.mappings.Mapping;
import org.springframework.stereotype.Service;

@Service
public class FlatMapping implements Mapping<FlatEntity, FlatDto> {

    @Override
    public FlatDto mapToDto(FlatEntity entity) {
        return null;
    }

    @Override
    public FlatEntity mapToEntity(FlatDto dto) {
        return null;
    }
}
