package com.example.house.service.impl;

import com.example.house.dto.OwnerDto;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.entity.OwnerEntity;
import com.example.house.entity.converter.OwnerName;
import com.example.house.repository.OwnerRepository;
import com.example.house.service.OwnerService;
import com.example.house.utils.mapping.impl.OwnerMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Optional<OwnerDto> createNewOwner(OwnerDto newOwnerDto) {
        OwnerEntity newOwnerEntity = new OwnerEntity();

        newOwnerEntity.setName(newOwnerDto.getName());
        newOwnerEntity.setPhoneNumber(newOwnerDto.getPhoneNumber());
        List<FlatOwnerEntity> flatOwnerEntities = new ArrayList<>(newOwnerDto.getFlats().size());
        newOwnerEntity.setFlatOwnerEntities(flatOwnerEntities);

        return Optional.of(ownerMapping.mapToDto(ownerRepository.save(newOwnerEntity)));
    }

    @Override
    public OwnerDto updateOwner(Long id, OwnerDto newOwnerDto) {
        OwnerEntity ownerEntity = ownerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        OwnerEntity newOwnerEntity = ownerMapping.mapToEntity(newOwnerDto);

        ownerEntity.setFlatOwnerEntities(newOwnerEntity.getFlatOwnerEntities());
        ownerEntity.setName(newOwnerEntity.getName());
        ownerEntity.setPhoneNumber(newOwnerEntity.getPhoneNumber());

        return ownerMapping.mapToDto(ownerRepository.save(ownerEntity));
    }

    @Override
    public OwnerDto deleteOwner(Long id) {
        OwnerDto owner = ownerMapping.mapToDto(ownerRepository.findById(id).orElse(null));

        if (owner != null) {
            ownerRepository.deleteById(id);
        }

        return owner;
    }
}
