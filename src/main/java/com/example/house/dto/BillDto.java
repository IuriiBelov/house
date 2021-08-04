package com.example.house.dto;

import com.example.house.utils.BillStatus;

import java.util.Calendar;

public class BillDto {

    private Integer flatNumber;
    private Integer number;
    private Calendar date;
    private BillStatus billStatus;

    public BillDto() {
    }

    public BillDto(Integer flatNumber, Integer number, Calendar date, BillStatus billStatus) {
        this.flatNumber = flatNumber;
        this.date = date;
        this.billStatus = billStatus;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
