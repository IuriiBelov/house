package com.example.house.utils.mapping;

import com.example.house.dto.BillDtoRequest;
import com.example.house.dto.BillDtoResponse;
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

    public BillDtoResponse mapToDto(BillEntity billEntity) {
        BillDtoResponse billDtoResponse = new BillDtoResponse();

        billDtoResponse.setId(billEntity.getId());
        billDtoResponse.setFlatNumber(billEntity.getBillFlatEntity().getNumber());
        billDtoResponse.setDate(billEntity.getDate());
        billDtoResponse.setBillStatus(billEntity.getBillStatus());

        return billDtoResponse;
    }

    public BillEntity mapToEntity(BillDtoRequest billDtoRequest)
            throws IllegalArgumentException {

        BillEntity billEntity = new BillEntity();

        List<FlatEntity> billFlat = flatRepository.findByNumber(billDtoRequest.getFlatNumber());
        if (billFlat.isEmpty()) {
            throw new IllegalArgumentException(billDtoRequest.getFlatNumber() +
                    "Is an illegal flat number");
        }
        billEntity.setBillFlatEntity(billFlat.get(0));
        billEntity.setDate(billDtoRequest.getDate());
        billEntity.setBillStatus(billDtoRequest.getBillStatus());

        return billEntity;
    }
}
