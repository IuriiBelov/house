package com.example.house.services;

import com.example.house.dtos.BillDto;
import com.example.house.dtos.FlatDto;
import com.example.house.dtos.OwnerDto;

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
    FlatDto getFlatById(String id);

    /**
     * Возвращает все счета квартиры с данным уникальным идентификатором
     * @param id идентификатор квартиры
     * @return все счета квартиры
     * @see BillDto
     */
    List<BillDto> getFlatBillsById(String id);

    /**
     * Возвращает всех владельцев квартиры с данным уникальным идентификатором
     * @param id идентификатор квартиры
     * @return все владельцы квартиры
     * @see OwnerDto
     */
    List<OwnerDto> getFlatOwnersById(String id);
}
