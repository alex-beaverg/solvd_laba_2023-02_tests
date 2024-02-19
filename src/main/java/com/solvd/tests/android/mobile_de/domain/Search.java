package com.solvd.tests.android.mobile_de.domain;

public class Search {
    private final String vehicle;
    private final int priceFrom;
    private final int priceTo;

    public Search(String vehicle, int priceFrom, int priceTo) {
        this.vehicle = vehicle;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
    }

    public String getVehicle() {
        return vehicle;
    }

    public int getPriceFrom() {
        return priceFrom;
    }

    public int getPriceTo() {
        return priceTo;
    }
}
