package com.example.house.service.impl;

import com.example.house.dto.OwnerDtoResponse;
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
        OwnerDtoResponse expectedOwnerDto = new OwnerDtoResponse(id, new OwnerName("Ivan", "Ivanov"),
                "1234567");

        Mockito
                .when(ownerRepository.findById(id))
                .thenReturn(Optional.of(ownerEntity));
        Mockito
                .when(ownerMapping.mapToDto(Mockito.any(OwnerEntity.class)))
                .thenReturn(expectedOwnerDto);

        OwnerDtoResponse actualOwnerDto = ownerService.getOwnerById(id);

        Assertions
                .assertThat(actualOwnerDto.getId())
                .isEqualTo(expectedOwnerDto.getId());
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
        OwnerDtoResponse newOwnerDto = new OwnerDtoResponse(ownerName, "1234567");
    }
}