package com.example.house.entity;

import com.example.house.entity.converter.OwnerName;
import com.example.house.entity.converter.OwnerNameConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /*
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
     */
    @Column(name = "name")
    @Convert(converter = OwnerNameConverter.class)
    private OwnerName name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "ownerEntity", cascade = CascadeType.ALL)
    private List<FlatOwnerEntity> flatOwnerEntities = new ArrayList<>();

    public OwnerEntity() {}

    public OwnerEntity(OwnerName name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public OwnerEntity(Long id, OwnerName name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public OwnerName getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<FlatOwnerEntity> getFlatOwnerEntities() {
        return flatOwnerEntities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(OwnerName name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFlatOwnerEntities(List<FlatOwnerEntity> flatOwnerEntities) {
        this.flatOwnerEntities = flatOwnerEntities;
    }
}
