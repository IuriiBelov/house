package com.example.house.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blocks")
public class BlockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Integer number;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "blockEntity")
    private List<FlatEntity> flatEntities = new ArrayList<>();

    public BlockEntity() {}

    public BlockEntity(Integer number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public List<FlatEntity> getFlatEntities() {
        return flatEntities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setFlatEntities(List<FlatEntity> flatEntities) {
        this.flatEntities = flatEntities;
    }
}
