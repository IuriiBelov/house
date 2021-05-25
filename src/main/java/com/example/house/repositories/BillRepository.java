package com.example.house.repositories;

import com.example.house.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
    Bill getOneById(Long id);
}
