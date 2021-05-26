package com.example.house.repositories;

import com.example.house.entities.FlatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FlatRepository extends JpaRepository<FlatEntity, Long> {
    FlatEntity getOneById(Long id);

    FlatEntity getOneByNumber(Integer number);

    @Query("select * from flats where block_id=:id")
    List<FlatEntity> findByBlockId(@Param("id") Long id);
}
