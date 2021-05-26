package com.example.house.repositories;

import com.example.house.entities.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
    BillEntity getOneById(Long id);
}
