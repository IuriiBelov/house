package com.example.house.utils.mapping;

import com.example.house.dto.BillDto;
import com.example.house.entity.BillEntity;
import com.example.house.entity.FlatEntity;
import com.example.house.repository.FlatRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillMapping {

    private final FlatRepository flatRepository;

    public BillMapping(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    public BillDto mapToDto(BillEntity billEntity) {
        BillDto billDto = new BillDto();

        billDto.setId(billEntity.getId());
        billDto.setFlatNumber(billEntity.getBillFlatEntity().getNumber());
        billDto.setBillNumber(billEntity.getNumber());
        billDto.setDate(billEntity.getDate());
        billDto.setBillStatus(billEntity.getBillStatus());

        return billDto;
    }

    public BillEntity mapToEntity(BillDto billDto)
            throws IllegalArgumentException {

        BillEntity billEntity = new BillEntity();

        List<FlatEntity> billFlat = flatRepository.findByNumber(billDto.getFlatNumber());
        if (billFlat.isEmpty()) {
            throw new IllegalArgumentException(billDto.getFlatNumber() +
                    "Is an illegal flat number");
        }
        billEntity.setBillFlatEntity(billFlat.get(0));
        billEntity.setNumber(billDto.getBillNumber());
        billEntity.setDate(billDto.getDate());
        billEntity.setBillStatus(billDto.getBillStatus());

        return billEntity;
    }
}
