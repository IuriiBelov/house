package com.example.house.dto;

import com.example.house.entity.converter.OwnerName;

import java.util.List;

public class OwnerDto {

    private OwnerName name;
    private String phoneNumber;
    private List<Integer> flatsNumbers;

    public OwnerDto() {
    }

    public OwnerDto(OwnerName name, String phoneNumber, List<Integer> flatsNumbers) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.flatsNumbers = flatsNumbers;
    }

    public OwnerName getName() {
        return name;
    }

    public void setName(OwnerName name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Integer> getFlatsNumbers() {
        return flatsNumbers;
    }

    public void setFlatsNumbers(List<Integer> flatsNumbers) {
        this.flatsNumbers = flatsNumbers;
    }
}
