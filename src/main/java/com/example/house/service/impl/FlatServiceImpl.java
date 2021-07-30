package com.example.house.service.impl;

import com.example.house.dto.BillDtoResponse;
import com.example.house.dto.FlatDtoResponse;
import com.example.house.dto.OwnerDtoResponse;
import com.example.house.entity.FlatEntity;
import com.example.house.entity.FlatOwnerEntity;
import com.example.house.repository.FlatRepository;
import com.example.house.service.FlatService;
import com.example.house.utils.mapping.BillMapping;
import com.example.house.utils.mapping.FlatMapping;
import com.example.house.utils.mapping.OwnerMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlatServiceImpl implements FlatService {

    private final FlatRepository flatRepository;
    private final FlatMapping flatMapping;
    private final BillMapping billMapping;
    private final OwnerMapping ownerMapping;

    public FlatServiceImpl(FlatRepository flatRepository,
                           FlatMapping flatMapping,
                           BillMapping billMapping,
                           OwnerMapping ownerMapping) {
        this.flatRepository = flatRepository;
        this.flatMapping = flatMapping;
        this.billMapping = billMapping;
        this.ownerMapping = ownerMapping;
    }

    @Override
    public List<FlatDtoResponse> getAllFlats(int page, int size) {
        return flatRepository
                .findAll(PageRequest.of(page - 1, size, Sort.by("id")))
                .stream()
                .map(flatMapping::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlatDtoResponse getFlatById(Long id) {
        Optional<FlatEntity> flat = flatRepository.findById(id);
        return flatMapping.mapToDto(flat.orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<BillDtoResponse> getFlatBillsById(Long id) {
        return flatRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new)
                .getBillEntities()
                .stream()
                .map(billMapping::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OwnerDtoResponse> getFlatOwnersById(Long id) {
        return flatRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new)
                .getFlatOwnerEntities()
                .stream()
                .map(FlatOwnerEntity::getOwnerEntity)
                .map(ownerMapping::mapToDto)
                .collect(Collectors.toList());
    }
}
