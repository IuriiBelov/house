package com.example.house.services.impl;

import com.example.house.dtos.OwnerDto;
import com.example.house.entities.OwnerEntity;
import com.example.house.repositories.OwnerRepository;
import com.example.house.services.OwnerService;
import com.example.house.utils.MappingUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;
    private MappingUtils mappingUtils;

    public OwnerServiceImpl(OwnerRepository ownerRepository, MappingUtils mappingUtils) {
        this.ownerRepository = ownerRepository;
        this.mappingUtils = mappingUtils;
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        List<OwnerDto> allOwnerDtos = ownerRepository
                .findAll()
                .stream()
                .map(mappingUtils::mapToOwnerDto)
                .collect(Collectors.toList());
        return allOwnerDtos;
    }

    @Override
    public OwnerDto getOwnerById(String id) {
        OwnerDto ownerDto = mappingUtils.mapToOwnerDto(
                ownerRepository.getOneById(Long.parseLong(id)));
        return ownerDto;
    }

    @Override
    public void createNewOwner(OwnerDto newOwnerDto) {
        ownerRepository.save(mappingUtils.mapToOwnerEntity(newOwnerDto));
    }

    @Override
    public void updateOwner(String id, OwnerDto newOwnerDto) {
        OwnerDto oldOwnerDto = new OwnerDto();
        oldOwnerDto.setId(Long.parseLong(id));
        OwnerEntity oldOwnerEntity = mappingUtils.mapToOwnerEntity(oldOwnerDto);

        oldOwnerEntity = ownerRepository.getOneById(oldOwnerEntity.getId());
        if (oldOwnerEntity != null) {
            ownerRepository.save(mappingUtils.mapToOwnerEntity(newOwnerDto));
        }
    }

    @Override
    public void deleteOwner(String id) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(Long.parseLong(id));
        OwnerEntity ownerEntity = mappingUtils.mapToOwnerEntity(ownerDto);

        ownerRepository.deleteById(ownerEntity.getId());
    }
}
