package com.example.house.utils.mappings.impl;

import com.example.house.dtos.OwnerDto;
import com.example.house.entities.OwnerEntity;
import com.example.house.repositories.FlatOwnerRepository;
import com.example.house.utils.mappings.Mapping;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapping implements Mapping<OwnerEntity, OwnerDto> {

    private FlatOwnerRepository flatOwnerRepository;

    public OwnerMapping(FlatOwnerRepository flatOwnerRepository) {
        this.flatOwnerRepository = flatOwnerRepository;
    }

    @Override
    public OwnerDto mapToDto(OwnerEntity entity) {
        OwnerDto dto = new OwnerDto();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhoneNumber(entity.getPhoneNumber());

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
