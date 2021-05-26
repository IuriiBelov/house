package com.example.house.dto;

public class FlatDto {
    private Long id;
    private Integer number;
    private Long blockId;
    private Integer floor;
    private Double area;

    public FlatDto() {}

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Long getBlockId() {
        return blockId;
    }

    public Integer getFloor() {
        return floor;
    }

    public Double getArea() {
        return area;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
