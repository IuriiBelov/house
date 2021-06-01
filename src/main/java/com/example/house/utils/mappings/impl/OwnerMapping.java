package com.example.house.utils.mappings.impl;

import com.example.house.dtos.OwnerDto;
import com.example.house.entities.OwnerEntity;
import com.example.house.repositories.FlatOwnerRepository;
import com.example.house.utils.mappings.Mapping;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OwnerMapping implements Mapping<OwnerEntity, OwnerDto> {

    private FlatOwnerRepository flatOwnerRepository;

    private FlatMapping flatMapping;

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
                .getFlatOwners()
                .stream()
                .map(elem -> elem.getFlatOwnerFlat())
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
        entity.setFlatOwners(flatOwnerRepository.findByOwnerId(dto.getId()));

        return entity;
    }
}
