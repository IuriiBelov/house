package com.example.house.entity;

import javax.persistence.*;

@Entity
@Table(name = "flats_owners")
public class FlatOwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private FlatEntity flatOwnerFlatEntity;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity flatOwnerOwnerEntity;

    public FlatOwnerEntity() {}

    public FlatOwnerEntity(FlatEntity flatOwnerFlatEntity, OwnerEntity flatOwnerOwnerEntity) {
        this.flatOwnerFlatEntity = flatOwnerFlatEntity;
        this.flatOwnerOwnerEntity = flatOwnerOwnerEntity;
    }

    public Long getId() {
        return id;
    }

    public FlatEntity getFlatOwnerFlatEntity() {
        return flatOwnerFlatEntity;
    }

    public OwnerEntity getFlatOwnerOwnerEntity() {
        return flatOwnerOwnerEntity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFlatOwnerFlatEntity(FlatEntity flatOwnerFlatEntity) {
        this.flatOwnerFlatEntity = flatOwnerFlatEntity;
    }

    public void setFlatOwnerOwnerEntity(OwnerEntity flatOwnerOwnerEntity) {
        this.flatOwnerOwnerEntity = flatOwnerOwnerEntity;
    }
}
