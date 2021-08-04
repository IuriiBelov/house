package com.example.house.utils.mapping;

import com.example.house.dto.FlatDto;
import com.example.house.entity.FlatEntity;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.entity.OwnerEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FlatMapping {

    public FlatDto mapToDto(FlatEntity flatEntity) {
        FlatDto flatDto = new FlatDto();

        flatDto.setNumber(flatEntity.getNumber());
        flatDto.setBlockNumber(flatEntity.getBlockEntity().getNumber());
        flatDto.setFloor(flatEntity.getFloor());
        flatDto.setMeasurements(flatEntity.getMeasurements());
        flatDto.setOwnerNames(flatEntity
                .getFlatOwnerEntities()
                .stream()
                .map(FlatOwnerEntity::getOwnerEntity)
                .map(OwnerEntity::getName)
                .collect(Collectors.toList()));

        return flatDto;
    }
}
