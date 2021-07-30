package com.example.house.utils.mapping;

import com.example.house.dto.OwnerDtoRequest;
import com.example.house.dto.OwnerDtoResponse;
import com.example.house.entity.FlatEntity;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.entity.OwnerEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OwnerMapping {

    public OwnerDtoResponse mapToDto(OwnerEntity ownerEntity) {
        OwnerDtoResponse ownerDtoResponse = new OwnerDtoResponse();

        ownerDtoResponse.setId(ownerEntity.getId());
        ownerDtoResponse.setName(ownerEntity.getName());
        ownerDtoResponse.setPhoneNumber(ownerEntity.getPhoneNumber());
        ownerDtoResponse.setFlatsNumbers(ownerEntity
                .getFlatOwnerEntities()
                .stream()
                .map(FlatOwnerEntity::getFlatEntity)
                .map(FlatEntity::getNumber)
                .collect(Collectors.toList()));

        return ownerDtoResponse;
    }

    public OwnerEntity mapToEntity(OwnerDtoRequest ownerDtoRequest) {
        OwnerEntity ownerEntity = new OwnerEntity();

        ownerEntity.setName(ownerDtoRequest.getName());
        ownerEntity.setPhoneNumber(ownerDtoRequest.getPhoneNumber());

        return ownerEntity;
    }
}
