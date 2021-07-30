package com.example.house.service;

import com.example.house.dto.BillDtoRequest;
import com.example.house.dto.BillDtoResponse;

import java.util.List;

/**
 * Сервис получения информации о счетах многоквартирного дома
 */
public interface BillService {

    /**
     * Возвращает все счета многоквартирного дома
     * @return все счета многоквартирного дома
     */
    List<BillDtoResponse> getAllBills(int page, int size);

    /**
     * Возвращает счет по его уникальному идентификатору
     * @param id идентификатор счета
     * @return трансферный объект счета
     * @see BillDtoResponse
     */
    BillDtoResponse getBillById(Long id);

    /**
     * Создаёт новый счёт
     * @param newBillDto трансферный объект нового счёта
     */
    BillDtoResponse createNewBill(BillDtoRequest newBillDto);

    /**
     * Обновляет информацию о счёте по его уникальному идентификатору
     * @param id идентификатор счёта
     * @param newBillDto обновлённый трансферный объект счёта
     */
    BillDtoResponse updateBill(Long id, BillDtoRequest newBillDto);

    /**
     * Удаляет счёт по его уникальному идентификатору
     * @param id идентификатор счёта
     */
    BillDtoResponse deleteBill(Long id);
}
