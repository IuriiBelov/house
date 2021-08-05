package com.example.house.dto;

import com.example.house.entity.converter.OwnerName;
import com.example.house.entity.embeddable.FlatMeasurements;

import java.util.List;

public class FlatDto {

    private Long id;
    private Integer flatNumber;
    private Integer blockNumber;
    private Integer floor;
    private FlatMeasurements measurements;
    private List<OwnerName> ownerNames;

    public FlatDto() {}

    public FlatDto(Long id, Integer flatNumber, Integer blockNumber, Integer floor,
                   FlatMeasurements measurements, List<OwnerName> ownerNames) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.blockNumber = blockNumber;
        this.floor = floor;
        this.measurements = measurements;
        this.ownerNames = ownerNames;
    }

    public Long getId() {
        return id;
    }

    public Integer getFlatNumber() {
        return flatNumber;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
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