package com.example.house.repository;

import com.example.house.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity, Long> {

    //@Query(value = "select bills from BillEntity bills where bills.id=:id")
    @Query(value = "from BillEntity where billFlatEntity.id=:id")
    List<BillEntity> findBillsByFlatId(Long id);
}
