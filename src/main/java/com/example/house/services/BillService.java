package com.example.house.services;

import com.example.house.entities.Bill;
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

    public List<Bill> getAllBills() {
        List<Bill> allBills = billRepository.findAll();
        return  allBills;
    }

    public Bill getBillById(String id) {
        Bill bill = billRepository.getOneById(Long.parseLong(id));
        return bill;
    }
}
