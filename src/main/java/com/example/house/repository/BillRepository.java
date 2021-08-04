package com.example.house.repository;

import com.example.house.entity.BillEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<BillEntity, Long> {

    //@Query(value = "select bills from BillEntity bills where bills.id=:id")
    @Query(value = "from BillEntity where billFlatEntity.id=:id")
    List<BillEntity> findBillsByFlatId(Long id);

    List<BillEntity> findByNumber(Integer number);

    void deleteByNumber(Integer number);

    Page<BillEntity> findAll(Pageable pageable);
}
