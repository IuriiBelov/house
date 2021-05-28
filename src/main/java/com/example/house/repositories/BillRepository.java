package com.example.house.repositories;

import com.example.house.entities.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
    BillEntity getOneById(Long id);

    @Query(value = "select * from bills where flat_id=:id", nativeQuery = true)
    List<BillEntity> findByFlatId(@Param("id") Long id);
}
