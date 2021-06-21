package com.example.house.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flats")
public class FlatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id")
    private BlockEntity blockEntity;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "area")
    private Double area;

    @OneToMany(mappedBy = "billFlatEntity")
    private List<BillEntity> billEntities = new ArrayList<>();

    // change list to set
    @OneToMany(mappedBy = "ownerEntity")
    private List<FlatOwnerEntity> flatOwnerEntities = new ArrayList<>();

    public FlatEntity() {}

    public FlatEntity(Integer number, BlockEntity blockEntity, Integer floor, Double area) {
        this.number = number;
        this.blockEntity = blockEntity;
        this.floor = floor;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public BlockEntity getBlockEntity() {
        return blockEntity;
    }

    public Integer getFloor() {
        return floor;
    }

    public Double getArea() {
        return area;
    }

    public List<BillEntity> getBillEntities() {
        return billEntities;
    }

    public List<FlatOwnerEntity> getFlatOwnerEntities() {
        return flatOwnerEntities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setBlockEntity(BlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setBillEntities(List<BillEntity> billEntities) {
        this.billEntities = billEntities;
    }

    public void setFlatOwnerEntities(List<FlatOwnerEntity> flatOwnerEntities) {
        this.flatOwnerEntities = flatOwnerEntities;
    }
}
