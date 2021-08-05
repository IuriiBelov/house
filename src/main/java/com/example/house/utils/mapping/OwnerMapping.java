package com.example.house.utils.mapping;

import com.example.house.dto.OwnerDto;
import com.example.house.entity.FlatEntity;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.entity.OwnerEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OwnerMapping {

    public OwnerDto mapToDto(OwnerEntity ownerEntity) {
        OwnerDto ownerDto = new OwnerDto();

        ownerDto.setId(ownerEntity.getId());
        ownerDto.setName(ownerEntity.getName());
        ownerDto.setPhoneNumber(ownerEntity.getPhoneNumber());
        ownerDto.setFlatsNumbers(ownerEntity
                .getFlatOwnerEntities()
                .stream()
                .map(FlatOwnerEntity::getFlatEntity)
                .map(FlatEntity::getNumber)
                .collect(Collectors.toList()));

        return ownerDto;
    }

    public OwnerEntity mapToEntity(OwnerDto ownerDto) {
        OwnerEntity ownerEntity = new OwnerEntity();

        ownerEntity.setName(ownerDto.getName());
        ownerEntity.setPhoneNumber(ownerDto.getPhoneNumber());

        return ownerEntity;
    }
}
