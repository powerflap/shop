package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

public class Product {
    @NotNull
    private final String title;

    private final int price;

    public Product(@NotNull String title, int price) {
        this.title = title;
        this.price = price;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}
