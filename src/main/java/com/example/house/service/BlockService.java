package com.example.house.service;

import com.example.house.dto.BlockDto;
import com.example.house.dto.FlatDto;

import java.util.List;

/**
 * Сервис получения информации о подъездах многоквартирного дома
 */
public interface BlockService {

    /**
     * Возвращает все подъезды многоквартирного дома
     * @return все подъезды многоквартирного дома
     */
    List<BlockDto> getAllBlocks(int page, int size);

    /**
     * Возвращает подъезд по его уникальному идентификатору
     * @param id уникальный идентификатор подъезда
     * @return трансферный объект подъезда
     * @see BlockDto
     */
    BlockDto getBlockById(Long id);

    /**
     * Возвращает все квартиры подъезда с данным уникальным идентификатором
     * @param id уникальный идентификатор подъезда
     * @return все квартиры подъезда
     * @see FlatDto
     */
    List<FlatDto> getBlockFlatsById(Long id);
}
