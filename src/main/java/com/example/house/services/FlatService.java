package com.example.house.services;

import com.example.house.dtos.BillDto;
import com.example.house.dtos.FlatDto;
import com.example.house.dtos.OwnerDto;
import com.example.house.entities.FlatOwnerEntity;
import com.example.house.repositories.FlatRepository;
import com.example.house.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatService {
    private FlatRepository flatRepository;
    private MappingUtils mappingUtils;

    @Autowired
    public FlatService(FlatRepository flatRepository, MappingUtils mappingUtils) {
        this.flatRepository = flatRepository;
        this.mappingUtils = mappingUtils;
    }

    public List<FlatDto> getAllFlats() {
        List<FlatDto> allFlatDtos = flatRepository
                .findAll()
                .stream()
                .map(mappingUtils::mapToFlatDto)
                .collect(Collectors.toList());
        return allFlatDtos;
    }

    public FlatDto getFlatById(String id) {
        FlatDto flatDto = mappingUtils.mapToFlatDto(
                flatRepository.getOneById(Long.parseLong(id)));
        return flatDto;
    }

    public List<BillDto> getFlatBillsById(String id) {
        List<BillDto> flatBillDtos = flatRepository
                .getOneById(Long.parseLong(id))
                .getBillEntities()
                .stream()
                .map(mappingUtils::mapToBillDto)
                .collect(Collectors.toList());
        return flatBillDtos;
    }

    public List<OwnerDto> getFlatOwnersById(String id) {
        List<OwnerDto> flatOwnerDtos = flatRepository
                .getOneById(Long.parseLong(id))
                .getFlatOwnerEntities()
                .stream()
                .map(elem -> elem.getFlatOwnerOwner())
                .collect(Collectors.toList())
                .stream()
                .map(mappingUtils::mapToOwnerDto)
                .collect(Collectors.toList());
        return flatOwnerDtos;
    }
}
