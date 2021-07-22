package com.example.house.dto;

import java.util.List;

public class BlockDto {

    private Long id;
    private Integer number;
    private List<FlatDto> flats;

    public BlockDto() {}

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public List<FlatDto> getFlats() {
        return flats;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setFlats(List<FlatDto> flats) {
        this.flats = flats;
    }

    @Override
    public String toString() {
        return "BlockDto{" +
                "id=" + id +
                ", number=" + number +
                ", flats=" + flats +
                '}';
    }
}
