package com.example.house.services.impl;

import com.example.house.dtos.OwnerDto;
import com.example.house.entities.OwnerEntity;
import com.example.house.repositories.OwnerRepository;
import com.example.house.services.OwnerService;
import com.example.house.utils.mappings.impl.OwnerMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;
    private OwnerMapping ownerMapping;

    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapping ownerMapping) {
        this.ownerRepository = ownerRepository;
        this.ownerMapping = ownerMapping;
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        List<OwnerDto> allOwnerDtos = ownerRepository
                .findAll()
                .stream()
                .map(ownerMapping::mapToDto)
                .collect(Collectors.toList());
        return allOwnerDtos;
    }

    @Override
    public OwnerDto getOwnerById(String id) {
        OwnerDto ownerDto = ownerMapping.mapToDto(
                ownerRepository.getOneById(Long.parseLong(id)));
        return ownerDto;
    }

    @Override
    public void createNewOwner(OwnerDto newOwnerDto) {
        ownerRepository.save(ownerMapping.mapToEntity(newOwnerDto));
    }

    @Override
    public void updateOwner(String id, OwnerDto newOwnerDto) {
        OwnerDto oldOwnerDto = new OwnerDto();
        oldOwnerDto.setId(Long.parseLong(id));
        OwnerEntity oldOwnerEntity = ownerMapping.mapToEntity(oldOwnerDto);

        oldOwnerEntity = ownerRepository.getOneById(oldOwnerEntity.getId());
        if (oldOwnerEntity != null) {
            ownerRepository.save(ownerMapping.mapToEntity(newOwnerDto));
        }
    }

    @Override
    public void deleteOwner(String id) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(Long.parseLong(id));
        OwnerEntity ownerEntity = ownerMapping.mapToEntity(ownerDto);

        ownerRepository.deleteById(ownerEntity.getId());
    }
}
