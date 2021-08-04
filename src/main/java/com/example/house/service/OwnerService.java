package com.example.house.service;

import com.example.house.dto.OwnerDto;

import java.util.List;
import java.util.Optional;

/**
 * Сервис получения информации о владельцах квартир многоквартирного дома
 */
public interface OwnerService {

    /**
     * Возвращает всех владельцев квартир многоквартирного дома
     * @return все владельцы квартир многоквартирного дома
     */
    List<OwnerDto> getAllOwners(int page, int size);

    /**
     * Возвращает владельца по его уникальному идентификатору
     * @param id уникальный идентификатор владельца
     * @return трансферный объект владельца
     * @see OwnerDto
     */
    OwnerDto getOwnerById(Long id);

    /**
     * Создаёт нового владельца
     * @param newOwnerDto трансферный объект нового владельца
     */
    Optional<OwnerDto> createNewOwner(OwnerDto newOwnerDto);

    /**
     * Обновляет информацию о владельце по его уникальному идентификатору
     * @param id уникальный идентификатор владельца
     * @param newOwnerDto обновлённый трансферный объект владельца
     */
    OwnerDto updateOwnerById(Long id, OwnerDto newOwnerDto);

    /**
     * Удаляет владельца по его уникальному идентификатору
     * @param id уникальный идентификатор владельца
     */
    OwnerDto deleteOwnerById(Long id);
}
