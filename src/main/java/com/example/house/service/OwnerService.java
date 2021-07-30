package com.example.house.service;

import com.example.house.dto.OwnerDtoRequest;
import com.example.house.dto.OwnerDtoResponse;

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
    List<OwnerDtoResponse> getAllOwners(int page, int size);

    /**
     * Возвращает владельца по его уникальному идентификатору
     * @param id идентификатор владельца
     * @return трансферный объект владельца
     * @see OwnerDtoResponse
     */
    OwnerDtoResponse getOwnerById(Long id);

    /**
     * Создаёт нового владельца
     * @param newOwnerDto трансферный объект нового владельца
     */
    Optional<OwnerDtoResponse> createNewOwner(OwnerDtoRequest newOwnerDto);

    /**
     * Обновляет информацию о владельце по его уникальному идентификатору
     * @param id идентификатор владельца
     * @param newOwnerDto обновлённый трансферный объект владельца
     */
    OwnerDtoResponse updateOwner(Long id, OwnerDtoRequest newOwnerDto);

    /**
     * Удаляет владельца по его уникальному идентификатору
     * @param id идентификатор владельца
     */
    OwnerDtoResponse deleteOwner(Long id);
}
