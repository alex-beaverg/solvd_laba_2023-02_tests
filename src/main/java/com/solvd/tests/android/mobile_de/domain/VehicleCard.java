package com.solvd.tests.android.mobile_de.domain;

import java.util.Objects;

public class VehicleCard {
    private String model;
    private double price;
    private double mileage;
    private String address;
    private String firstRegistration;
    private String performance;

    public VehicleCard() { }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstRegistration(String firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleCard that = (VehicleCard) o;
        return Double.compare(that.price, price) == 0 &&
                Double.compare(that.mileage, mileage) == 0 &&
                model.equals(that.model) &&
                address.equals(that.address) &&
                firstRegistration.equals(that.firstRegistration) &&
                performance.equals(that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, mileage, address, firstRegistration, performance);
    }

    @Override
    public String toString() {
        return "Vehicle Card: [" + model + ", " + price + ", " + mileage + ", " + address + ", " + firstRegistration + ", " + performance + "]";
    }
}
