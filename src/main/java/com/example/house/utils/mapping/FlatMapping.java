package com.example.house.utils.mapping;

import com.example.house.dto.FlatDto;
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

    public FlatDto mapToDto(FlatEntity flatEntity) {
        FlatDto flatDto = new FlatDto();

        flatDto.setId(flatEntity.getId());
        flatDto.setFlatNumber(flatEntity.getNumber());
        flatDto.setBlockNumber(flatEntity.getBlockEntity().getNumber());
        flatDto.setFloor(flatEntity.getFloor());
        flatDto.setFlatMeasurements(flatEntity.getMeasurements());
        flatDto.setBills(flatEntity
                .getBillEntities()
                .stream()
                .map(billMapping::mapToDto)
                .collect(Collectors.toList()));
        flatDto.setOwnersNames(flatEntity
                .getFlatOwnerEntities()
                .stream()
                .map(FlatOwnerEntity::getOwnerEntity)
                .map(OwnerEntity::getName)
                .collect(Collectors.toList()));

        return flatDto;
    }
}
