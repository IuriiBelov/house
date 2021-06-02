package com.example.house.repository;

import com.example.house.entity.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<BlockEntity, Long> {

    BlockEntity getOneById(Long id);

    BlockEntity getOneByNumber(Integer number);
}
