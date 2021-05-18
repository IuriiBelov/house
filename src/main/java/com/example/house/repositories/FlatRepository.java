package com.example.house.repositories;

import com.example.house.entities.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<Flat, Long> {}
