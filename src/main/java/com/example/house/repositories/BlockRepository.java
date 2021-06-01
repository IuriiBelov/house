package com.example.house.repositories;

import com.example.house.entities.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<BlockEntity, Long> {

    BlockEntity getOneById(Long id);

    BlockEntity getOneByNumber(Integer number);
}
