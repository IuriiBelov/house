package com.example.house.utils.mapping;

import com.example.house.dto.FlatDtoResponse;
import com.example.house.entity.FlatEntity;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.entity.OwnerEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FlatMapping {

    private final BillMapping billMapping;

    public FlatMapping(BillMapping billMapping) {
        this.billMapping = billMapping;
    }

    public FlatDtoResponse mapToDto(FlatEntity flatEntity) {
        FlatDtoResponse flatDtoResponse = new FlatDtoResponse();

        flatDtoResponse.setId(flatEntity.getId());
        flatDtoResponse.setNumber(flatEntity.getNumber());
        flatDtoResponse.setBlockNumber(flatEntity.getBlockEntity().getNumber());
        flatDtoResponse.setFloor(flatEntity.getFloor());
        flatDtoResponse.setMeasurements(flatEntity.getMeasurements());
        flatDtoResponse.setOwnerNames(flatEntity
                .getFlatOwnerEntities()
                .stream()
                .map(FlatOwnerEntity::getOwnerEntity)
                .map(OwnerEntity::getName)
                .collect(Collectors.toList()));
        flatDtoResponse.setBills(flatEntity
                .getBillEntities()
                .stream()
                .map(billMapping::mapToDto)
                .collect(Collectors.toList()));

        return flatDtoResponse;
    }
}
