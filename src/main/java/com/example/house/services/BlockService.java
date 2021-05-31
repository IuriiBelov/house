package com.example.house.services;

import com.example.house.dtos.BlockDto;
import com.example.house.dtos.FlatDto;

import java.util.List;

/**
 * Сервис получения информации о подъездах многоквартирного дома
 */
public interface BlockService {

    /**
     * Возвращает все подъезды многоквартирного дома
     * @return все подъезды многоквартирного дома
     */
    List<BlockDto> getAllBlocks();

    /**
     * Возвращает подъезд по его уникальному идентификатору
     * @param id идентификатор подъезда
     * @return трансферный объект подъезда
     * @see BlockDto
     */
    BlockDto getBlockById(String id);

    /**
     * Возвращает все квартиры подъезда с данным уникальным идентификатором
     * @param id идентификатор подъезда
     * @return все квартиры подъезда
     * @see FlatDto
     */
    List<FlatDto> getBlockFlatsById(String id);
}
