package com.example.house.services;

import com.example.house.dtos.OwnerDto;

import java.util.List;

/**
 * Сервис получения информации о владельцах квартир многоквартирного дома
 */
public interface OwnerService {

    List<OwnerDto> getAllOwners();

    OwnerDto getOwnerById(String id);

    void createNewOwner(OwnerDto newOwnerDto);

    void updateOwner(String id, OwnerDto newOwnerDto);

    void deleteOwner(String id);
}
