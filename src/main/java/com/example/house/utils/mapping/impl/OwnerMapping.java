package com.example.house.utils.mapping.impl;

import com.example.house.dto.OwnerDto;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.entity.OwnerEntity;
import com.example.house.repository.FlatOwnerRepository;
import com.example.house.utils.mapping.Mapping;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OwnerMapping implements Mapping<OwnerEntity, OwnerDto> {

    private final FlatOwnerRepository flatOwnerRepository;

    private final FlatMapping flatMapping;

    public OwnerMapping(FlatOwnerRepository flatOwnerRepository, FlatMapping flatMapping) {
        this.flatOwnerRepository = flatOwnerRepository;
        this.flatMapping = flatMapping;
    }

    @Override
    public OwnerDto mapToDto(OwnerEntity entity) {
        OwnerDto dto = new OwnerDto();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setFlats(entity
                .getFlatOwnerEntities()
                .stream()
                .map(FlatOwnerEntity::getFlatEntity)
                .collect(Collectors.toList())
                .stream()
                .map(flatMapping::mapToDto)
                .collect(Collectors.toList()));

        return dto;
    }

    @Override
    public OwnerEntity mapToEntity(OwnerDto dto) {
        OwnerEntity entity = new OwnerEntity();

        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setFlatOwnerEntities(flatOwnerRepository.findByOwnerId(dto.getId()));

        return entity;
    }
}
