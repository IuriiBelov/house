package com.example.house.service.impl;

import com.example.house.dto.OwnerDto;
import com.example.house.entity.OwnerEntity;
import com.example.house.entity.converter.OwnerName;
import com.example.house.repository.OwnerRepository;
import com.example.house.utils.mapping.OwnerMapping;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private OwnerMapping ownerMapping;

    @InjectMocks
    OwnerServiceImpl ownerService;

    @Test
    @DisplayName("Should find owner by id")
    public void shouldFindOwnerById() {
        Long id = 5L;

        OwnerEntity ownerEntity = new OwnerEntity(id, new OwnerName("Ivan", "Ivanov"),
                "1234567");
        OwnerDto expectedOwnerDto = new OwnerDto(new OwnerName("Ivan", "Ivanov"),
                "1234567", null);

        Mockito
                .when(ownerRepository.findById(id))
                .thenReturn(Optional.of(ownerEntity));
        Mockito
                .when(ownerMapping.mapToDto(Mockito.any(OwnerEntity.class)))
                .thenReturn(expectedOwnerDto);

        OwnerDto actualOwnerDto = ownerService.getOwnerById(id);

        Assertions
                .assertThat(actualOwnerDto.getName())
                .isEqualTo(expectedOwnerDto.getName());
        Assertions
                .assertThat(actualOwnerDto.getPhoneNumber())
                .isEqualTo(expectedOwnerDto.getPhoneNumber());
    }

    @Test
    @DisplayName("Should")
    public void should() {
        Long flatId = 5L;

        OwnerName ownerName = new OwnerName("Ivan", "Ivanov");
        OwnerDto newOwnerDto = new OwnerDto(ownerName, "1234567", null);
    }
}