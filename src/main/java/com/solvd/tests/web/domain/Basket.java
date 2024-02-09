package com.solvd.tests.web.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private double totalPrice;
    private List<ProductCard> products = new ArrayList<>();

    public Basket() { }

    public Basket(double totalPrice, List<ProductCard> products) {
        this.totalPrice = totalPrice;
        this.products = products;
    }

    public List<ProductCard> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCard> products) {
        this.products = products;
    }

    public void addProduct(ProductCard product) {
        this.products.add(product);
    }

    public void removeFirstProduct() {
        this.products.remove(0);
    }

    public void calculateAndSetTotalPrice() {
        this.totalPrice = products.stream().mapToDouble(ProductCard::getPrice).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Double.compare(basket.totalPrice, totalPrice) == 0 && Objects.equals(products, basket.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPrice, products);
    }
}
