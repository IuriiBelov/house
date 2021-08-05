package com.example.house.dto;

import com.example.house.utils.BillStatus;

import java.util.Calendar;

public class BillDto {

    private Long id;
    private Integer number;
    private Integer flatNumber;
    private Calendar date;
    private BillStatus billStatus;

    public BillDto() {
    }

    public BillDto(Long id, Integer flatNumber, Integer number, Calendar date,
                   BillStatus billStatus) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.number = number;
        this.date = date;
        this.billStatus = billStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
