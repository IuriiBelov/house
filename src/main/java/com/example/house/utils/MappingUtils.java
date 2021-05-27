package com.example.house.utils;

import com.example.house.dto.BillDto;
import com.example.house.dto.BlockDto;
import com.example.house.dto.FlatDto;
import com.example.house.dto.OwnerDto;
import com.example.house.entities.BillEntity;
import com.example.house.entities.BlockEntity;
import com.example.house.entities.FlatEntity;
import com.example.house.entities.OwnerEntity;
import com.example.house.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {
    private BillRepository billRepository;
    private BlockRepository blockRepository;
    private FlatRepository flatRepository;
    private FlatOwnerRepository flatOwnerRepository;

    @Autowired
    public MappingUtils(BillRepository billRepository, BlockRepository blockRepository,
                        FlatRepository flatRepository, FlatOwnerRepository flatOwnerRepository) {
        this.billRepository = billRepository;
        this.blockRepository = blockRepository;
        this.flatRepository = flatRepository;
        this.flatOwnerRepository = flatOwnerRepository;
    }

    public BillDto mapToBillDto(BillEntity billEntity) {
        BillDto billDto = new BillDto();

        billDto.setId(billEntity.getId());
        billDto.setFlatId(billEntity.getBillFlat().getId());
        billDto.setDate(billEntity.getDate());
        billDto.setBillStatus(billEntity.getBillStatus());

        return billDto;
    }

    public BillEntity mapToBillEntity(BillDto billDto) {
        BillEntity billEntity = new BillEntity();

        billEntity.setId(billDto.getId());
        billEntity.setBillFlat(flatRepository.getOneById(billDto.getId()));
        billEntity.setDate(billDto.getDate());
        billEntity.setBillStatus(billDto.getBillStatus());

        return billEntity;
    }

    public BlockDto mapToBlockDto(BlockEntity blockEntity) {
        BlockDto blockDto = new BlockDto();

        blockDto.setId(blockEntity.getId());
        blockDto.setNumber(blockEntity.getNumber());

        return blockDto;
    }

    public BlockEntity mapToBlockEntity(BlockDto blockDto) {
        BlockEntity blockEntity = new BlockEntity();

        blockEntity.setId(blockDto.getId());
        blockEntity.setNumber(blockDto.getNumber());
        blockEntity.setFlats(flatRepository.findByBlockId(blockDto.getId()));

        return blockEntity;
    }

    public FlatDto mapToFlatDto(FlatEntity flatEntity) {
        FlatDto flatDto = new FlatDto();

        flatDto.setId(flatEntity.getId());
        flatDto.setNumber(flatEntity.getNumber());
        flatDto.setBlockId(flatEntity.getBlockEntity().getId());
        flatDto.setFloor(flatEntity.getFloor());
        flatDto.setArea(flatEntity.getArea());

        return flatDto;
    }

    public FlatEntity mapToFlatEntity(FlatDto flatDto) {
        FlatEntity flatEntity = new FlatEntity();

        flatEntity.setId(flatDto.getId());
        flatEntity.setNumber(flatDto.getNumber());
        flatEntity.setBlockEntity(blockRepository.getOneById(flatDto.getBlockId()));
        flatEntity.setFloor(flatEntity.getFloor());
        flatEntity.setArea(flatDto.getArea());
        flatEntity.setBillEntities(billRepository.findByFlatId(flatDto.getId()));
        flatEntity.setFlatOwnerEntities(flatOwnerRepository.findByFlatId(flatDto.getId()));

        return flatEntity;
    }

    public OwnerDto mapToOwnerDto(OwnerEntity ownerEntity) {
        OwnerDto ownerDto = new OwnerDto();

        ownerDto.setId(ownerEntity.getId());
        ownerDto.setFirstName(ownerEntity.getFirstName());
        ownerDto.setLastName(ownerEntity.getLastName());
        ownerDto.setPhoneNumber(ownerEntity.getPhoneNumber());

        return ownerDto;
    }

    public OwnerEntity mapToOwnerEntity(OwnerDto ownerDto) {
        OwnerEntity ownerEntity = new OwnerEntity();

        ownerEntity.setId(ownerDto.getId());
        ownerEntity.setFirstName(ownerDto.getFirstName());
        ownerEntity.setLastName(ownerDto.getLastName());
        ownerEntity.setPhoneNumber(ownerDto.getPhoneNumber());
        ownerEntity.setFlatOwners(flatOwnerRepository.findByOwnerId(ownerDto.getId()));

        return ownerEntity;
    }
}
