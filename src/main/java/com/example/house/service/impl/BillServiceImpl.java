package com.example.house.service.impl;

import com.example.house.dto.BillDto;
import com.example.house.entity.BillEntity;
import com.example.house.repository.BillRepository;
import com.example.house.service.BillService;
import com.example.house.utils.mapping.impl.BillMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<BillDto> getAllBills(int page, int size) {
        return billRepository
                .findAll(PageRequest.of(page - 1, size, Sort.by("id")))
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
    public BillDto createNewBill(BillDto newBillDto) {
        return billMapping.mapToDto(billRepository.save(billMapping.mapToEntity(newBillDto)));
    }

    @Override
    public BillDto updateBill(Long id, BillDto newBillDto) {
        BillEntity billEntity = billRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        BillEntity newBillEntity = billMapping.mapToEntity(newBillDto);

        billEntity.setBillFlatEntity(newBillEntity.getBillFlatEntity());
        billEntity.setBillStatus(newBillEntity.getBillStatus());
        billEntity.setDate(newBillEntity.getDate());

        return billMapping.mapToDto(billRepository.save(billEntity));
    }

    @Override
    public void deleteBill(Long id) {
        if (billRepository.findById(id).isPresent()) {
            billRepository.deleteById(id);
        }
    }
}
