package com.example.house.service.impl;

import com.example.house.dto.OwnerDtoRequest;
import com.example.house.dto.OwnerDtoResponse;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.entity.OwnerEntity;
import com.example.house.repository.FlatRepository;
import com.example.house.repository.OwnerRepository;
import com.example.house.service.OwnerService;
import com.example.house.utils.mapping.OwnerMapping;
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
    private final FlatRepository flatRepository;
    private final OwnerMapping ownerMapping;

    public OwnerServiceImpl(OwnerRepository ownerRepository,
                            FlatRepository flatRepository,
                            OwnerMapping ownerMapping) {

        this.ownerRepository = ownerRepository;
        this.flatRepository = flatRepository;
        this.ownerMapping = ownerMapping;
    }

    @Override
    public List<OwnerDtoResponse> getAllOwners(int page, int size) {
        return ownerRepository
                .findAll(PageRequest.of(page - 1, size, Sort.by("id")))
                .stream()
                .map(ownerMapping::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDtoResponse getOwnerById(Long id) {
        Optional<OwnerEntity> owner = ownerRepository.findById(id);
        return ownerMapping.mapToDto(owner.orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public Optional<OwnerDtoResponse> createNewOwner(OwnerDtoRequest newOwnerDto) {
        OwnerEntity newOwnerEntity = ownerMapping.mapToEntity(newOwnerDto);

        ownerRepository.save(newOwnerEntity);

        setNewFlatsForOwner(newOwnerEntity, newOwnerDto);

        return Optional.of(ownerMapping.mapToDto(ownerRepository.save(newOwnerEntity)));
    }

    @Override
    public OwnerDtoResponse updateOwner(Long id, OwnerDtoRequest newOwnerDto)
            throws IllegalArgumentException {

        OwnerEntity ownerEntity = ownerRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);

        ownerEntity.setName(newOwnerDto.getName());
        ownerEntity.setPhoneNumber(newOwnerDto.getPhoneNumber());

        setNewFlatsForOwner(ownerEntity, newOwnerDto);

        return ownerMapping.mapToDto(ownerRepository.save(ownerEntity));
    }

    private void setNewFlatsForOwner(OwnerEntity ownerEntity, OwnerDtoRequest ownerDtoRequest) {

        List<FlatOwnerEntity> flatOwnerEntities = new ArrayList<>();

        for (Integer number: ownerDtoRequest.getFlatsNumbers()) {
            flatOwnerEntities.add(new FlatOwnerEntity(flatRepository.findByNumber(number).get(0),
                    ownerEntity));
        }

        ownerEntity.setFlatOwnerEntities(flatOwnerEntities);
    }

    @Override
    public OwnerDtoResponse deleteOwner(Long id) {
        OwnerDtoResponse owner = ownerMapping.mapToDto(ownerRepository.findById(id).get());

        if (owner != null) {
            ownerRepository.deleteById(id);
        }

        return owner;
    }
}
