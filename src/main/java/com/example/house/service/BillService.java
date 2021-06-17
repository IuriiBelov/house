package com.example.house.service;

import com.example.house.dto.BillDto;

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

    /**
     * Создаёт новый счёт
     * @param newBillDto трансферный объект нового счёта
     */
    void createNewBill(BillDto newBillDto);

    /**
     * Обновляет информацию о счёте по его уникальному идентификатору
     * @param id идентификатор счёта
     * @param newBillDto обновлённый трансферный объект счёта
     */
    void updateBill(Long id, BillDto newBillDto);

    /**
     * Удаляет счёт по его уникальному идентификатору
     * @param id идентификатор счёта
     */
    void deleteBill(Long id);
}
