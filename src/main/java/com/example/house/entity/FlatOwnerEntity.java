package com.example.house.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "flats_owners")
@org.hibernate.annotations.Immutable
public class FlatOwnerEntity {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "owner_id")
        protected Long ownerId;

        @Column(name = "flat_id")
        protected Long flatId;

        public Id() {
        }

        public Id(Long ownerId, Long flatId) {
            this.ownerId = ownerId;
            this.flatId = flatId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;
            Id id = (Id) o;
            return Objects.equals(ownerId, id.ownerId) && Objects.equals(flatId, id.flatId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(ownerId, flatId);
        }
    };

    @EmbeddedId
    protected Id id = new Id();

    @ManyToOne
    @JoinColumn(name = "flat_id", insertable = false, updatable = false)
    private FlatEntity flatEntity;

    @ManyToOne
    @JoinColumn(name = "owner_id", insertable = false, updatable = false)
    private OwnerEntity ownerEntity;

    public FlatOwnerEntity() {}

    public FlatOwnerEntity(FlatEntity flatEntity, OwnerEntity ownerEntity) {
        this.flatEntity = flatEntity;
        this.ownerEntity = ownerEntity;

        this.id.flatId = flatEntity.getId();
        this.id.ownerId = ownerEntity.getId();

        flatEntity.getFlatOwnerEntities().add(this);
        ownerEntity.getFlatOwnerEntities().add(this);
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public FlatEntity getFlatEntity() {
        return flatEntity;
    }

    public void setFlatEntity(FlatEntity flatEntity) {
        this.flatEntity = flatEntity;
    }

    public OwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(OwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
    }
}
