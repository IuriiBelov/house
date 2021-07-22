package com.example.house.dto;

import java.util.List;

public class FlatDto {

    private Long id;
    private Integer number;
    private Long blockId;
    private Integer floor;
    private Double area;
    private List<OwnerDto> owners;
    private List<BillDto> bills;

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

    public List<OwnerDto> getOwners() {
        return owners;
    }

    public List<BillDto> getBills() {
        return bills;
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

    public void setOwners(List<OwnerDto> owners) {
        this.owners = owners;
    }

    public void setBills(List<BillDto> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "FlatDto{" +
                "id=" + id +
                ", number=" + number +
                ", blockId=" + blockId +
                ", floor=" + floor +
                ", area=" + area +
                ", owners=" + owners +
                ", bills=" + bills +
                '}';
    }
}
