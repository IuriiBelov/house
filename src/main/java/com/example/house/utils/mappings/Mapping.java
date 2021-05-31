package com.example.house.utils.mappings;

import org.springframework.stereotype.Service;

/**
 * Сервис перевода объектов из Dto в Entity и обратно
 * @param <E> класс Entity
 * @param <D> класс Dto
 */
public interface Mapping<E, D> {

    /**
     * Переводит объект из Entity в Dto
     * @param entity объект Entity
     * @return объект Dto
     */
    D mapToDto(E entity);

    /**
     * Переводит объект из Dto в Entity
     * @param dto объект Dto
     * @return объект Entity
     */
    E mapToEntity(D dto);
}
