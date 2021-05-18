package com.example.house.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flats")
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "area")
    private Double area;

    @OneToMany(mappedBy = "billFlat")
    private List<Bill> bills = new ArrayList<>();

    @OneToMany(mappedBy = "flatOwnerFlat")
    private List<FlatOwner> flatOwners = new ArrayList<>();

    public Flat() {}

    public Flat(Integer number, Block block, Integer floor, Double area) {
        this.number = number;
        this.block = block;
        this.floor = floor;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public Block getBlock() {
        return block;
    }

    public Integer getFloor() {
        return floor;
    }

    public Double getArea() {
        return area;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public List<FlatOwner> getFlatOwners() {
        return flatOwners;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public void setFlatOwners(List<FlatOwner> flatOwners) {
        this.flatOwners = flatOwners;
    }
}
