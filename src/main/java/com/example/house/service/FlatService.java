package com.example.house.service;

import com.example.house.dto.BillDto;
import com.example.house.dto.FlatDto;
import com.example.house.dto.OwnerDto;

import java.util.List;

/**
 * Сервис получения информации о квартирах многоквартирного дома
 */
public interface FlatService {

    /**
     * Возвращает все квартиры многоквартирного дома
     * @return все квартиры многоквартирного дома
     */
    List<FlatDto> getAllFlats();

    /**
     * Возвращает квартиру по её уникальному идентификатору
     * @param id идентификатор квартиры
     * @return трансферный объект квартиры
     * @see FlatDto
     */
    FlatDto getFlatById(Long id);

    /**
     * Возвращает все счета квартиры с данным уникальным идентификатором
     * @param id идентификатор квартиры
     * @return все счета квартиры
     * @see BillDto
     */
    List<BillDto> getFlatBillsById(Long id);

    /**
     * Возвращает всех владельцев квартиры с данным уникальным идентификатором
     * @param id идентификатор квартиры
     * @return все владельцы квартиры
     * @see OwnerDto
     */
    List<OwnerDto> getFlatOwnersById(Long id);
}
