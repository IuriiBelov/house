package com.example.house.entities;

import com.example.house.utils.BillStatus;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "bills")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private FlatEntity billFlatEntity;

    @Column(name = "bill_date")
    @Temporal(TemporalType.DATE)
    private Calendar date;

    @Column(name = "bill_status")
    @Enumerated(EnumType.STRING)
    private BillStatus billStatus;

    public BillEntity() {}

    public BillEntity(FlatEntity billFlatEntity, Calendar date, BillStatus billStatus) {
        this.billFlatEntity = billFlatEntity;
        this.date = date;
        this.billStatus = billStatus;
    }

    public Long getId() {
        return id;
    }

    public FlatEntity getBillFlat() {
        return billFlatEntity;
    }

    public Calendar getDate() {
        return date;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBillFlat(FlatEntity billFlatEntity) {
        this.billFlatEntity = billFlatEntity;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
