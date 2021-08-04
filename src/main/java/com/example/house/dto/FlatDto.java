package com.example.house.dto;

import com.example.house.entity.converter.OwnerName;
import com.example.house.entity.embeddable.FlatMeasurements;

import java.util.List;

public class FlatDto {

    private Integer number;
    private Integer blockNumber;
    private Integer floor;
    private FlatMeasurements measurements;
    private List<OwnerName> ownerNames;

    public FlatDto() {}

    public Integer getNumber() {
        return number;
    }

    public Integer getBlockNumber() {
        return blockNumber;
    }

    public Integer getFloor() {
        return floor;
    }

    public FlatMeasurements getMeasurements() {
        return measurements;
    }

    public List<OwnerName> getOwnerNames() {
        return ownerNames;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setMeasurements(FlatMeasurements measurements) {
        this.measurements = measurements;
    }

    public void setOwnerNames(List<OwnerName> ownerNames) {
        this.ownerNames = ownerNames;
    }
}
