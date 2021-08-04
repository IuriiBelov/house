package com.example.house.dto;

import java.util.List;

public class BlockDto {

    private Integer number;
    private List<Integer> flatsNumbers;

    public BlockDto() {}

    public Integer getNumber() {
        return number;
    }

    public List<Integer> getFlatsNumbers() {
        return flatsNumbers;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setFlatsNumbers(List<Integer> flatsNumbers) {
        this.flatsNumbers = flatsNumbers;
    }
}
