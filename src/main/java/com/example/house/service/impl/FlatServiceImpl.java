package com.example.house.service.impl;

import com.example.house.dto.BillDto;
import com.example.house.dto.FlatDto;
import com.example.house.dto.OwnerDto;
import com.example.house.entity.FlatEntity;
import com.example.house.repository.FlatRepository;
import com.example.house.service.FlatService;
import com.example.house.utils.mapping.impl.BillMapping;
import com.example.house.utils.mapping.impl.FlatMapping;
import com.example.house.utils.mapping.impl.OwnerMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlatServiceImpl implements FlatService {

    private FlatRepository flatRepository;
    private FlatMapping flatMapping;
    private BillMapping billMapping;
    private OwnerMapping ownerMapping;

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
    public List<FlatDto> getAllFlats() {
        List<FlatDto> allFlatDtos = flatRepository
                .findAll()
                .stream()
                .map(flatMapping::mapToDto)
                .collect(Collectors.toList());
        return allFlatDtos;
    }

    @Override
    public FlatDto getFlatById(Long id) {
        Optional<FlatEntity> flat = flatRepository.findById(id);
        return flatMapping.mapToDto(flat.orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<BillDto> getFlatBillsById(Long id) {
        List<BillDto> flatBillDtos = flatRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new)
                .getBillEntities()
                .stream()
                .map(billMapping::mapToDto)
                .collect(Collectors.toList());
        return flatBillDtos;
    }

    @Override
    public List<OwnerDto> getFlatOwnersById(Long id) {
        List<OwnerDto> flatOwnerDtos = flatRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new)
                .getFlatOwnerEntities()
                .stream()
                .map(elem -> elem.getOwnerEntity())
                .collect(Collectors.toList())
                .stream()
                .map(ownerMapping::mapToDto)
                .collect(Collectors.toList());
        return flatOwnerDtos;
    }
}
