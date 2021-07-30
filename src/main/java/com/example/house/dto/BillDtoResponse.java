package com.example.house.dto;

import com.example.house.utils.BillStatus;

import java.util.Calendar;

public class BillDtoResponse {

    private Long id;
    private Integer flatNumber;
    private Calendar date;
    private BillStatus billStatus;

    public BillDtoResponse() {}

    public BillDtoResponse(Long id, Integer flatNumber, Calendar date, BillStatus billStatus) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.date = date;
        this.billStatus = billStatus;
    }

    public Long getId() {
        return id;
    }

    public Integer getFlatNumber() {
        return flatNumber;
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

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
