package com.example.house.service.impl;

import com.example.house.dto.BillDto;
import com.example.house.entity.BillEntity;
import com.example.house.repository.BillRepository;
import com.example.house.service.BillService;
import com.example.house.utils.mapping.impl.BillMapping;
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
        return billRepository
                .findAll()
                .stream()
                .map(billMapping::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BillDto getBillById(Long id) {
        Optional<BillEntity> bill = billRepository.findById(id);
        return billMapping.mapToDto(bill.orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public void createNewBill(BillDto newBillDto) {
        billRepository.save(billMapping.mapToEntity(newBillDto));
    }

    @Override
    public void updateBill(Long id, BillDto newBillDto) {
        if (billRepository.findById(id).isPresent()) {
            billRepository.save(billMapping.mapToEntity(newBillDto));
        }
    }

    @Override
    public void deleteBill(Long id) {
        if (billRepository.findById(id).isPresent()) {
            billRepository.deleteById(id);
        }
    }
}
