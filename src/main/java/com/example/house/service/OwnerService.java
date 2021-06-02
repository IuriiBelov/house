package com.example.house.service;

import com.example.house.dto.OwnerDto;

import java.util.List;

/**
 * Сервис получения информации о владельцах квартир многоквартирного дома
 */
public interface OwnerService {

    /**
     * Возвращает всех владельцев квартир многоквартирного дома
     * @return все владельцы квартир многоквартирного дома
     */
    List<OwnerDto> getAllOwners();

    /**
     * Возвращает владельца по его уникальному идентификатору
     * @param id идентификатор владельца
     * @return трансферный объект владельца
     * @see OwnerDto
     */
    OwnerDto getOwnerById(String id);

    /**
     * Создаёт нового владельца
     * @param newOwnerDto трансферный объект нового владельца
     */
    void createNewOwner(OwnerDto newOwnerDto);

    /**
     * Обновляет информацию о владельце по его уникальному идентификатору
     * @param id идентификатор владельца
     * @param newOwnerDto обновлённый трансферный объект владельца
     */
    void updateOwner(String id, OwnerDto newOwnerDto);

    /**
     * Удаляет владельца по его уникальному идентификатору
     * @param id идентификатор владельца
     */
    void deleteOwner(String id);
}
