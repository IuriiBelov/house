package com.example.house.service.impl;

import com.example.house.dto.BillDtoRequest;
import com.example.house.dto.BillDtoResponse;
import com.example.house.entity.BillEntity;
import com.example.house.repository.BillRepository;
import com.example.house.service.BillService;
import com.example.house.utils.mapping.BillMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public List<BillDtoResponse> getAllBills(int page, int size) {
        return billRepository
                .findAll(PageRequest.of(page - 1, size, Sort.by("id")))
                .stream()
                .map(billMapping::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BillDtoResponse getBillById(Long id) {
        Optional<BillEntity> bill = billRepository.findById(id);
        return billMapping.mapToDto(bill.orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public BillDtoResponse createNewBill(BillDtoRequest newBillDto) {
        return billMapping.mapToDto(billRepository.save(billMapping.mapToEntity(newBillDto)));
    }

    @Override
    public BillDtoResponse updateBill(Long id, BillDtoRequest newBillDto)
            throws IllegalArgumentException {

        BillEntity billEntity = billRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);

        return billMapping.mapToDto(billRepository.save(billMapping.mapToEntity(newBillDto)));
    }

    @Override
    public BillDtoResponse deleteBill(Long id) {
        BillDtoResponse bill = billMapping.mapToDto(billRepository.findById(id).get());

        if (bill != null) {
            billRepository.deleteById(id);
        }

        return bill;
    }
}
