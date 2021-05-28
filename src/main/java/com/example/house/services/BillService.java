package com.example.house.services;

import com.example.house.dtos.BillDto;

import java.util.List;

/**
 * Сервис получения информации о счетах многоквартирного дома
 */
public interface BillService {

    /**
     * Возвращает все счета многоквартирного дома
     * @return все счета многоквартирного дома
     */
    List<BillDto> getAllBills();

    /**
     * Возвращает счет по его уникальному идентификатору
     * @param id идентификатор счета
     * @return трансферный объект счета
     * @see BillDto
     */
    BillDto getBillById(Long id);
}
