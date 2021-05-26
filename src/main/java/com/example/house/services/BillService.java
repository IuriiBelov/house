package com.example.house.services;

import com.example.house.entities.BillEntity;
import com.example.house.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private BillRepository billRepository;

    @Autowired
    public void setBillRepository(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<BillEntity> getAllBills() {
        List<BillEntity> allBillEntities = billRepository.findAll();
        return allBillEntities;
    }

    public BillEntity getBillById(String id) {
        BillEntity billEntity = billRepository.getOneById(Long.parseLong(id));
        return billEntity;
    }
}
