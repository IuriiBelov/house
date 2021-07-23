package com.example.house.repository;

import com.example.house.entity.FlatEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<FlatEntity, Long> {

    FlatEntity findByNumber(Integer number);

    Page<FlatEntity> findAll(Pageable pageable);
}
