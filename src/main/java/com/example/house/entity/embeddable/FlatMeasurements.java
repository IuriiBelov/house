package com.example.house.entity.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class FlatMeasurements {

    private Double allArea;

    private Double livingArea;

    public FlatMeasurements() {
    }

    public FlatMeasurements(Double allArea, Double livingArea) {
        this.allArea = allArea;
        this.livingArea = livingArea;
    }

    public Double getAllArea() {
        return allArea;
    }

    public void setAllArea(Double allArea) {
        this.allArea = allArea;
    }

    public Double getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(Double livingArea) {
        this.livingArea = livingArea;
    }
}
