package com.example.house.dto;

import com.example.house.entity.converter.OwnerName;

import java.io.Serializable;
import java.util.List;

public class OwnerDto implements Serializable {

    private Long id;
    private OwnerName name;
    private String phoneNumber;
    private List<Integer> flatsNumbers;

    public OwnerDto() {
    }

    public OwnerDto(Long id, OwnerName name, String phoneNumber, List<Integer> flatsNumbers) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.flatsNumbers = flatsNumbers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "OwnerDto{" +
                "id=" + id +
                ", name=" + name.toString() +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", flatsNumbers=" + flatsNumbers.toString() +
                '}';
    }
}
