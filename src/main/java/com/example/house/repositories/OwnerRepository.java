package com.example.house.repositories;

import com.example.house.entities.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
    OwnerEntity getOneById(Long id);
}
