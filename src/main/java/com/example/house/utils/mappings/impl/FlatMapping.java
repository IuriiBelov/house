package com.example.house.utils.mappings.impl;

import com.example.house.dtos.FlatDto;
import com.example.house.entities.FlatEntity;
import com.example.house.repositories.BillRepository;
import com.example.house.repositories.BlockRepository;
import com.example.house.repositories.FlatOwnerRepository;
import com.example.house.utils.mappings.Mapping;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FlatMapping implements Mapping<FlatEntity, FlatDto> {

    private OwnerMapping ownerMapping;
    private BillMapping billMapping;

    private BlockRepository blockRepository;
    private BillRepository billRepository;
    private FlatOwnerRepository flatOwnerRepository;

    public FlatMapping(OwnerMapping ownerMapping,
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
                .map(elem -> elem.getFlatOwnerOwner())
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
        entity.setBlockEntity(blockRepository.getOneById(dto.getBlockId()));
        entity.setFloor(entity.getFloor());
        entity.setArea(dto.getArea());

        //flatRepository.findById(flatDto.getId()).ifPresent();
        entity.setBillEntities(billRepository.findBillsByFlatId(dto.getId()));

        entity.setFlatOwnerEntities(flatOwnerRepository.findByFlatId(dto.getId()));

        return entity;
    }
}
