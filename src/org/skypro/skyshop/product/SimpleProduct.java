package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(@NotNull String title, int price) {
        super(title);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной или быть равной нулю");
        }
        this.price = price;
    }
    @Override
    public @NotNull int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getTitle() + ": " + getPrice();
    }
}
