package com.example.house.dto;

import com.example.house.entity.converter.OwnerName;

import java.util.List;

public class OwnerDtoResponse {

    private Long id;
    private OwnerName name;
    private String phoneNumber;
    private List<Integer> flatsNumbers;

    public OwnerDtoResponse() {}

    public OwnerDtoResponse(OwnerName ownerName, String phoneNumber) {
        this.name = ownerName;
        this.phoneNumber = phoneNumber;
    }

    public OwnerDtoResponse(Long id, OwnerName name, String phoneNumber) {
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

    public List<Integer> getFlatsNumbers() {
        return flatsNumbers;
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

    public void setFlatsNumbers(List<Integer> flatsNumbers) {
        this.flatsNumbers = flatsNumbers;
    }
}
