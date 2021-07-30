package com.example.house.service;

import com.example.house.dto.BillDtoResponse;
import com.example.house.dto.FlatDtoResponse;
import com.example.house.dto.OwnerDtoResponse;

import java.util.List;

/**
 * Сервис получения информации о квартирах многоквартирного дома
 */
public interface FlatService {

    /**
     * Возвращает все квартиры многоквартирного дома
     * @return все квартиры многоквартирного дома
     */
    List<FlatDtoResponse> getAllFlats(int page, int size);

    /**
     * Возвращает квартиру по её уникальному идентификатору
     * @param id идентификатор квартиры
     * @return трансферный объект квартиры
     * @see FlatDtoResponse
     */
    FlatDtoResponse getFlatById(Long id);

    /**
     * Возвращает все счета квартиры с данным уникальным идентификатором
     * @param id идентификатор квартиры
     * @return все счета квартиры
     * @see BillDtoResponse
     */
    List<BillDtoResponse> getFlatBillsById(Long id);

    /**
     * Возвращает всех владельцев квартиры с данным уникальным идентификатором
     * @param id идентификатор квартиры
     * @return все владельцы квартиры
     * @see OwnerDtoResponse
     */
    List<OwnerDtoResponse> getFlatOwnersById(Long id);
}
