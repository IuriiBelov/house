package com.example.house.dto;

import java.util.List;

public class BlockDtoResponse {

    private Long id;
    private Integer number;
    private List<Integer> flatsNumbers;

    public BlockDtoResponse() {}

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public List<Integer> getFlatsNumbers() {
        return flatsNumbers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setFlatsNumbers(List<Integer> flatsNumbers) {
        this.flatsNumbers = flatsNumbers;
    }
}