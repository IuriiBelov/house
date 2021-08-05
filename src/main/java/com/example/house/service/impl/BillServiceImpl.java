package com.example.house.service.impl;

import com.example.house.dto.BillDto;
import com.example.house.entity.BillEntity;
import com.example.house.repository.BillRepository;
import com.example.house.service.BillService;
import com.example.house.utils.mapping.BillMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<BillDto> getAllBills(int page, int size) {
        return billRepository
                .findAll(PageRequest.of(page - 1, size, Sort.by("id")))
                .stream()
                .map(billMapping::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BillDto getBillById(Long id) {
        BillEntity bill = billRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);

        return billMapping.mapToDto(bill);
    }

    @Override
    public BillDto createNewBill(BillDto newBillDto) throws IllegalArgumentException {
        if (billRepository.findByNumber(newBillDto.getBillNumber()).size() != 0) {
            throw new IllegalArgumentException("Bill with such number already exists");
        }
        return billMapping.mapToDto(billRepository.save(billMapping.mapToEntity(newBillDto)));
    }

    @Override
    public BillDto updateBillById(Long id, BillDto newBillDto) throws IllegalArgumentException {

        BillEntity billEntity = billRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);

        BillEntity newBillEntity = billMapping.mapToEntity(newBillDto);

        billEntity.setBillFlatEntity(newBillEntity.getBillFlatEntity());
        billEntity.setBillStatus(newBillEntity.getBillStatus());
        billEntity.setNumber(newBillEntity.getNumber());
        billEntity.setDate(newBillEntity.getDate());

        return billMapping.mapToDto(billRepository.save(billEntity));
    }

    @Override
    public BillDto deleteBillById(Long id) {
        BillDto bill = billMapping.mapToDto(billRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new));

        billRepository.deleteById(id);

        return bill;
    }
}
