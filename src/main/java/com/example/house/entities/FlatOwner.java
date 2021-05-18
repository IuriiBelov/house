package com.example.house.entities;

import javax.persistence.*;

@Entity
@Table(name = "flats_owners")
public class FlatOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flatOwnerFlat;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner flatOwnerOwner;

    public FlatOwner() {}

    public Long getId() {
        return id;
    }

    public Flat getFlatOwnerFlat() {
        return flatOwnerFlat;
    }

    public Owner getFlatOwnerOwner() {
        return flatOwnerOwner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFlatOwnerFlat(Flat flatOwnerFlat) {
        this.flatOwnerFlat = flatOwnerFlat;
    }

    public void setFlatOwnerOwner(Owner flatOwnerOwner) {
        this.flatOwnerOwner = flatOwnerOwner;
    }
}
