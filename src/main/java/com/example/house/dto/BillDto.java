package com.example.house.dto;

import com.example.house.utils.BillStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Calendar;

public class BillDto {

    private Long id;
    private Long flatId;
    private Calendar date;
    private BillStatus billStatus;

    public BillDto() {}

    public Long getId() {
        return id;
    }

    public Long getFlatId() {
        return flatId;
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

    public void setFlatId(Long flatId) {
        this.flatId = flatId;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
