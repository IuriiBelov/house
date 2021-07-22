package com.example.house.dto;

import java.util.List;

public class OwnerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<FlatDto> flats;

    public OwnerDto() {}

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFlats(List<FlatDto> flats) {
        this.flats = flats;
    }

    @Override
    public String toString() {
        return "OwnerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", flats=" + flats +
                '}';
    }
}
