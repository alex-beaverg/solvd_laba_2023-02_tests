package com.solvd.tests.web.domain;

import java.util.Objects;

public class ProductCard {
    private final String title;
    private final double price;

    public ProductCard(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCard that = (ProductCard) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }
}
