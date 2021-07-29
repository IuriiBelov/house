package com.example.house.utils.mapping.impl;

import com.example.house.dto.OwnerDto;
import com.example.house.entity.FlatEntity;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.entity.OwnerEntity;
import com.example.house.entity.converter.OwnerName;
import com.example.house.repository.FlatOwnerRepository;
import com.example.house.utils.mapping.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerMapping implements Mapping<OwnerEntity, OwnerDto> {

    private final FlatOwnerRepository flatOwnerRepository;

    private final FlatMapping flatMapping;

    private static final Logger LOGGER = LoggerFactory.getLogger("logger");

    public OwnerMapping(FlatOwnerRepository flatOwnerRepository, FlatMapping flatMapping) {
        this.flatOwnerRepository = flatOwnerRepository;
        this.flatMapping = flatMapping;
    }

    @Override
    public OwnerDto mapToDto(OwnerEntity entity) {
        OwnerDto dto = new OwnerDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());

        List<FlatEntity> flatEntities = entity
                .getFlatOwnerEntities()
                .stream()
                .map(FlatOwnerEntity::getFlatEntity)
                .collect(Collectors.toList());
        dto.setFlats(flatEntities
                .stream()
                .map(flatMapping::mapToDtoWithNull)
                .collect(Collectors.toList()));

        return dto;
    }

    public OwnerDto mapToDtoWithNull(OwnerEntity entity) {
        OwnerDto dto = new OwnerDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setFlats(null);

        return dto;
    }

    @Override
    public OwnerEntity mapToEntity(OwnerDto dto) {
        OwnerEntity entity = new OwnerEntity();

        entity.setId(dto.getId());
        entity.setName(new OwnerName(dto.getName().getFirstName(),
                dto.getName().getLastName()));
        entity.setPhoneNumber(dto.getPhoneNumber());

        return entity;
    }
}
