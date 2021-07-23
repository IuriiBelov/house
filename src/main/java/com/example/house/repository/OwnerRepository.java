package com.example.house.repository;

import com.example.house.entity.OwnerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {

    Page<OwnerEntity> findAll(Pageable pageable);
}
