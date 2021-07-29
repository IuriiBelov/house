package com.example.house.dto;

import com.example.house.entity.converter.OwnerName;

import java.util.List;

public class OwnerDto {

    private Long id;
    private OwnerName name;
    private String phoneNumber;
    private List<FlatDto> flats;

    public OwnerDto() {}

    public OwnerDto(OwnerName ownerName, String phoneNumber) {
        this.name = ownerName;
        this.phoneNumber = phoneNumber;
    }

    public OwnerDto(Long id, OwnerName name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public OwnerName getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<FlatDto> getFlats() {
        return flats;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(OwnerName name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFlats(List<FlatDto> flats) {
        this.flats = flats;
    }
}
