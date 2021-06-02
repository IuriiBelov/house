package com.example.house.service.impl;

import com.example.house.dto.OwnerDto;
import com.example.house.entity.OwnerEntity;
import com.example.house.repository.OwnerRepository;
import com.example.house.service.OwnerService;
import com.example.house.utils.mapping.impl.OwnerMapping;
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