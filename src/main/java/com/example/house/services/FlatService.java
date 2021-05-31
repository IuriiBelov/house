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

    FlatDto getFlatById(String id);

    List<BillDto> getFlatBillsById(String id);

    List<OwnerDto> getFlatOwnersById(String id);
}
