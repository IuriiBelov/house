package com.example.house.entity.converter;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OwnerName)) return false;
        OwnerName ownerName = (OwnerName) o;
        return Objects.equals(getFirstName(), ownerName.getFirstName()) && Objects.equals(getLastName(), ownerName.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "OwnerName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
