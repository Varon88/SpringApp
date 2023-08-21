package com.product.product.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private final String name;
    private final double price;
    private final int id;
    private final String category;


    public Product(@JsonProperty("name") String name, @JsonProperty("price")double price, /*@JsonProperty("id")*/int id,@JsonProperty("category") String category) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
}
