package com.example.house.service.impl;

import com.example.house.dto.OwnerDto;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.entity.OwnerEntity;
import com.example.house.repository.FlatOwnerRepository;
import com.example.house.repository.FlatRepository;
import com.example.house.repository.OwnerRepository;
import com.example.house.service.OwnerService;
import com.example.house.utils.mapping.OwnerMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final FlatRepository flatRepository;
    private final FlatOwnerRepository flatOwnerRepository;
    private final OwnerMapping ownerMapping;

    public OwnerServiceImpl(OwnerRepository ownerRepository,
                            FlatRepository flatRepository,
                            FlatOwnerRepository flatOwnerRepository,
                            OwnerMapping ownerMapping) {

        this.ownerRepository = ownerRepository;
        this.flatRepository = flatRepository;
        this.flatOwnerRepository = flatOwnerRepository;
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
        return ownerMapping.mapToDto(ownerRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new));
    }

    @Transactional
    @Override
    public Optional<OwnerDto> createNewOwner(OwnerDto newOwnerDto) {
        OwnerEntity newOwnerEntity = ownerMapping.mapToEntity(newOwnerDto);

        ownerRepository.save(newOwnerEntity);

        setNewFlatsForOwner(newOwnerEntity, newOwnerDto);

        return Optional.of(ownerMapping.mapToDto(newOwnerEntity));
        //return Optional.of(ownerMapping.mapToDto(ownerRepository.save(newOwnerEntity)));
    }

    @Override
    public OwnerDto updateOwnerById(Long id, OwnerDto newOwnerDto)
            throws IllegalArgumentException {

        OwnerEntity ownerEntity = ownerRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);

        ownerEntity.setName(newOwnerDto.getName());
        ownerEntity.setPhoneNumber(newOwnerDto.getPhoneNumber());

        setNewFlatsForOwner(ownerEntity, newOwnerDto);

        return ownerMapping.mapToDto(ownerEntity);
    }

    private void setNewFlatsForOwner(OwnerEntity ownerEntity, OwnerDto ownerDto) {

        List<FlatOwnerEntity> flatOwnerEntities = new ArrayList<>();

        for (Integer number: ownerDto.getFlatsNumbers()) {
            FlatOwnerEntity flatOwnerEntity = new FlatOwnerEntity(
                    flatRepository.findFlatEntityByNumber(number), ownerEntity);
            //flatOwnerRepository.save(flatOwnerEntity);
            flatOwnerEntities.add(flatOwnerEntity);
        }

        ownerEntity.setFlatOwnerEntities(flatOwnerEntities);
    }

    @Override
    public OwnerDto deleteOwnerById(Long id) {
        OwnerEntity ownerEntity = ownerRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);

        OwnerDto ownerDto = ownerMapping.mapToDto(ownerEntity);

        ownerRepository.deleteById(ownerEntity.getId());

        return ownerDto;
    }
}
