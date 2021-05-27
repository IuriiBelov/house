package com.example.house.services;

import com.example.house.dto.OwnerDto;
import com.example.house.entities.OwnerEntity;
import com.example.house.repositories.OwnerRepository;
import com.example.house.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {
    private OwnerRepository ownerRepository;
    private MappingUtils mappingUtils;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, MappingUtils mappingUtils) {
        this.ownerRepository = ownerRepository;
        this.mappingUtils = mappingUtils;
    }

    public List<OwnerDto> getAllOwners() {
        List<OwnerDto> allOwnerDtos = ownerRepository
                .findAll()
                .stream()
                .map(mappingUtils::mapToOwnerDto)
                .collect(Collectors.toList());
        return allOwnerDtos;
    }

    public OwnerDto getOwnerById(String id) {
        OwnerDto ownerDto = mappingUtils.mapToOwnerDto(
                ownerRepository.getOneById(Long.parseLong(id)));
        return ownerDto;
    }

    public void createNewOwner(OwnerDto newOwnerDto) {
        ownerRepository.save(mappingUtils.mapToOwnerEntity(newOwnerDto));
    }

    public void updateOwner(String id, OwnerDto newOwnerDto) {
        OwnerDto oldOwnerDto = new OwnerDto();
        oldOwnerDto.setId(Long.parseLong(id));
        OwnerEntity oldOwnerEntity = mappingUtils.mapToOwnerEntity(oldOwnerDto);

        oldOwnerEntity = ownerRepository.getOneById(oldOwnerEntity.getId());
        if (oldOwnerEntity != null) {
            ownerRepository.save(mappingUtils.mapToOwnerEntity(newOwnerDto));
        }
    }

    public void deleteOwner(String id) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(Long.parseLong(id));
        OwnerEntity ownerEntity = mappingUtils.mapToOwnerEntity(ownerDto);

        ownerRepository.deleteById(ownerEntity.getId());
    }
}
