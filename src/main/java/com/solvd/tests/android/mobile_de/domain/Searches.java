package com.solvd.tests.android.mobile_de.domain;

import com.zebrunner.carina.utils.R;

public enum Searches {
    BIKE_SEARCH(
            R.TESTDATA.get("android.mobile_de.search.bike.model"),
            Integer.parseInt(R.TESTDATA.get("android.mobile_de.search.bike.price_from")),
            Integer.parseInt(R.TESTDATA.get("android.mobile_de.search.bike.price_to"))
    );

    private final String model;
    private final int priceFrom;
    private final int priceTo;

    Searches(String model, int priceFrom, int priceTo) {
        this.model = model;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
    }

    public String getModel() {
        return model;
    }

    public int getPriceFrom() {
        return priceFrom;
    }

    public int getPriceTo() {
        return priceTo;
    }
}
