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

    public FlatEntity getFlatOwnerFlat() {
        return flatOwnerFlatEntity;
    }

    public OwnerEntity getFlatOwnerOwner() {
        return flatOwnerOwnerEntity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFlatOwnerFlat(FlatEntity flatOwnerFlatEntity) {
        this.flatOwnerFlatEntity = flatOwnerFlatEntity;
    }

    public void setFlatOwnerOwner(OwnerEntity flatOwnerOwnerEntity) {
        this.flatOwnerOwnerEntity = flatOwnerOwnerEntity;
    }
}
