package com.example.house.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "bills")
public class Bill {
    public enum BillStatus {
        PAID,
        UNPAID
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat billFlat;

    @Column(name = "bill_date")
    @Temporal(TemporalType.DATE)
    private Calendar date;

    @Column(name = "bill_status")
    @Enumerated(EnumType.STRING)
    private BillStatus billStatus;

    public Bill() {}

    public Bill(Flat billFlat, Calendar date, BillStatus billStatus) {
        this.billFlat = billFlat;
        this.date = date;
        this.billStatus = billStatus;
    }

    public Long getId() {
        return id;
    }

    public Flat getBillFlat() {
        return billFlat;
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

    public void setBillFlat(Flat billFlat) {
        this.billFlat = billFlat;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
