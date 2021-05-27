package com.example.house.repositories;

import com.example.house.entities.FlatOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlatOwnerRepository extends JpaRepository<FlatOwnerEntity, Long> {
    @Query("select * from flats_owners where flat_id=:id")
    List<FlatOwnerEntity> findByFlatId(@Param("id") Long id);

    @Query("select * from flats_owners where owner_id=:id")
    List<FlatOwnerEntity> findByOwnerId(@Param("id") Long id);
}
