package com.example.house.repository;

import com.example.house.entity.BlockEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<BlockEntity, Long> {

    Page<BlockEntity> findAll(Pageable pageable);
}
