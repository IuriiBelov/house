package com.example.house.entity.converter;

import java.io.Serializable;

public class OwnerName implements Serializable {

    private String firstName;
    private String lastName;

    public OwnerName() {
    }

    public OwnerName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
