package com.example.house.repository;

import com.example.house.entity.FlatOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlatOwnerRepository extends JpaRepository<FlatOwnerEntity, Long> {

    @Query(value = "select * from flats_owners where flat_id=:id", nativeQuery = true)
    List<FlatOwnerEntity> findByFlatId(@Param("id") Long id);

    @Query(value = "select * from flats_owners where owner_id=:id", nativeQuery = true)
    List<FlatOwnerEntity> findByOwnerId(@Param("id") Long id);
}
