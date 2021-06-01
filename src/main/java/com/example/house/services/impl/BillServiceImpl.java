package com.example.house.services.impl;

import com.example.house.dtos.BillDto;
import com.example.house.entities.BillEntity;
import com.example.house.repositories.BillRepository;
import com.example.house.services.BillService;
import com.example.house.utils.mappings.impl.BillMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final BillMapping billMapping;

    public BillServiceImpl(BillRepository billRepository, BillMapping billMapping) {
        this.billRepository = billRepository;
        this.billMapping = billMapping;
    }

    @Override
    public List<BillDto> getAllBills() {
        List<BillDto> allBillDtos = billRepository
                .findAll()
                .stream()
                .map(billMapping::mapToDto)
                .collect(Collectors.toList());
        return allBillDtos;
    }

    @Override
    public BillDto getBillById(Long id) {
        Optional<BillEntity> bill = billRepository.findById(id);
        return billMapping.mapToDto(bill.orElseThrow(IllegalArgumentException::new));
    }
}
