package com.example.house.service.impl;

import com.example.house.dto.OwnerDto;
import com.example.house.entity.OwnerEntity;
import com.example.house.repository.OwnerRepository;
import com.example.house.service.OwnerService;
import com.example.house.utils.mapping.impl.OwnerMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapping ownerMapping;

    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapping ownerMapping) {
        this.ownerRepository = ownerRepository;
        this.ownerMapping = ownerMapping;
    }

    @Override
    public List<OwnerDto> getAllOwners(int page, int size) {
        return ownerRepository
                .findAll(PageRequest.of(page - 1, size, Sort.by("id")))
                .stream()
                .map(ownerMapping::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDto getOwnerById(Long id) {
        Optional<OwnerEntity> owner = ownerRepository.findById(id);
        return ownerMapping.mapToDto(owner.orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public OwnerDto createNewOwner(OwnerDto newOwnerDto) {
        return ownerMapping.mapToDto(ownerRepository.save(ownerMapping.mapToEntity(newOwnerDto)));
    }

    @Override
    public OwnerDto updateOwner(Long id, OwnerDto newOwnerDto) {
        OwnerEntity ownerEntity = ownerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        OwnerEntity newOwnerEntity = ownerMapping.mapToEntity(newOwnerDto);

        ownerEntity.setFlatOwnerEntities(newOwnerEntity.getFlatOwnerEntities());
        ownerEntity.setFirstName(newOwnerEntity.getFirstName());
        ownerEntity.setLastName(newOwnerEntity.getLastName());
        ownerEntity.setPhoneNumber(newOwnerEntity.getPhoneNumber());

        return ownerMapping.mapToDto(ownerRepository.save(ownerEntity));
    }

    @Override
    public void deleteOwner(Long id) {
        if (ownerRepository.findById(id).isPresent()) {
            ownerRepository.deleteById(id);
        }
    }
}
