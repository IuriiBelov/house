package com.example.house.services;

import com.example.house.dtos.BillDto;
import com.example.house.repositories.BillRepository;
import com.example.house.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {
    private BillRepository billRepository;
    private MappingUtils mappingUtils;

    @Autowired
    public BillService(BillRepository billRepository, MappingUtils mappingUtils) {
        this.billRepository = billRepository;
        this.mappingUtils = mappingUtils;
    }

    public List<BillDto> getAllBills() {
        List<BillDto> allBillDtos = billRepository
                .findAll()
                .stream()
                .map(mappingUtils::mapToBillDto)
                .collect(Collectors.toList());
        return allBillDtos;
    }

    public BillDto getBillById(String id) {
        BillDto billDto = mappingUtils.mapToBillDto(
                billRepository.getOneById(Long.parseLong(id)));
        return billDto;
    }
}
