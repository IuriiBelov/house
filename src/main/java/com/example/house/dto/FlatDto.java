package com.example.house.dto;

import com.example.house.entity.converter.OwnerName;
import com.example.house.entity.embeddable.FlatMeasurements;

import java.util.List;

public class FlatDto {

    private Long id;
    private Integer flatNumber;
    private Integer blockNumber;
    private Integer floor;
    private FlatMeasurements flatMeasurements;
    private List<BillDto> bills;
    private List<OwnerName> ownersNames;

    public FlatDto() {}

    public FlatDto(Long id, Integer flatNumber, Integer blockNumber, Integer floor,
                   FlatMeasurements flatMeasurements, List<BillDto> bills,
                   List<OwnerName> ownersNames) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.blockNumber = blockNumber;
        this.floor = floor;
        this.flatMeasurements = flatMeasurements;
        this.bills = bills;
        this.ownersNames = ownersNames;
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

    public FlatMeasurements getFlatMeasurements() {
        return flatMeasurements;
    }

    public List<BillDto> getBills() {
        return bills;
    }

    public List<OwnerName> getOwnersNames() {
        return ownersNames;
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

    public void setFlatMeasurements(FlatMeasurements flatMeasurements) {
        this.flatMeasurements = flatMeasurements;
    }

    public void setBills(List<BillDto> bills) {
        this.bills = bills;
    }

    public void setOwnersNames(List<OwnerName> ownersNames) {
        this.ownersNames = ownersNames;
    }
}
