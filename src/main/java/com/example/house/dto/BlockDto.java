package com.example.house.dto;

public class BlockDto {
    private Long id;
    private Integer number;

    public BlockDto() {}

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
