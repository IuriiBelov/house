package com.example.house.utils.mapping.impl;

import com.example.house.dto.FlatDto;
import com.example.house.entity.FlatEntity;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.repository.BillRepository;
import com.example.house.repository.BlockRepository;
import com.example.house.repository.FlatOwnerRepository;
import com.example.house.utils.mapping.Mapping;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FlatMapping implements Mapping<FlatEntity, FlatDto> {

    private final OwnerMapping ownerMapping;
    private final BillMapping billMapping;

    private final BlockRepository blockRepository;
    private final BillRepository billRepository;
    private final FlatOwnerRepository flatOwnerRepository;

    public FlatMapping(@Lazy OwnerMapping ownerMapping,
                       BillMapping billMapping,
                       BlockRepository blockRepository,
                       BillRepository billRepository,
                       FlatOwnerRepository flatOwnerRepository) {
        this.ownerMapping = ownerMapping;
        this.billMapping = billMapping;

        this.blockRepository = blockRepository;
        this.billRepository = billRepository;
        this.flatOwnerRepository = flatOwnerRepository;
    }

    @Override
    public FlatDto mapToDto(FlatEntity entity) {
        FlatDto dto = new FlatDto();

        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setBlockId(entity.getBlockEntity().getId());
        dto.setFloor(entity.getFloor());
        dto.setArea(entity.getArea());
        dto.setOwners(entity
                .getFlatOwnerEntities()
                .stream()
                .map(FlatOwnerEntity::getOwnerEntity)
                .collect(Collectors.toList())
                .stream()
                .map(ownerMapping::mapToDto)
                .collect(Collectors.toList()));
        dto.setBills(entity
                .getBillEntities()
                .stream()
                .map(billMapping::mapToDto)
                .collect(Collectors.toList()));

        return dto;
    }

    @Override
    public FlatEntity mapToEntity(FlatDto dto) {
        FlatEntity entity = new FlatEntity();

        entity.setId(dto.getId());
        entity.setNumber(dto.getNumber());
        entity.setBlockEntity(blockRepository
                .findById(dto.getBlockId())
                .orElseThrow(IllegalArgumentException::new));
        entity.setFloor(entity.getFloor());
        entity.setArea(dto.getArea());
        entity.setBillEntities(billRepository.findBillsByFlatId(dto.getId()));
        entity.setFlatOwnerEntities(flatOwnerRepository.findByFlatId(dto.getId()));

        return entity;
    }
}
