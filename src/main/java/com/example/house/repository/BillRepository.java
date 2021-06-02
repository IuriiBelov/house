package com.example.house.repository;

import com.example.house.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity, Long> {

    @Query(value = "select * from bills where flat_id=:id", nativeQuery = true)
    List<BillEntity> findBillsByFlatId(@Param("id") Long id);
}
