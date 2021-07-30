package com.example.house.service;

import com.example.house.dto.BlockDtoResponse;
import com.example.house.dto.FlatDtoResponse;

import java.util.List;

/**
 * Сервис получения информации о подъездах многоквартирного дома
 */
public interface BlockService {

    /**
     * Возвращает все подъезды многоквартирного дома
     * @return все подъезды многоквартирного дома
     */
    List<BlockDtoResponse> getAllBlocks(int page, int size);

    /**
     * Возвращает подъезд по его уникальному идентификатору
     * @param id идентификатор подъезда
     * @return трансферный объект подъезда
     * @see BlockDtoResponse
     */
    BlockDtoResponse getBlockById(Long id);

    /**
     * Возвращает все квартиры подъезда с данным уникальным идентификатором
     * @param id идентификатор подъезда
     * @return все квартиры подъезда
     * @see FlatDtoResponse
     */
    List<FlatDtoResponse> getBlockFlatsById(Long id);
}
