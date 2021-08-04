package com.example.house.repository;

import com.example.house.entity.OwnerEntity;
import com.example.house.entity.converter.OwnerName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {

    Page<OwnerEntity> findAll(Pageable pageable);
}
