package org.skypro.skyshop.product;
import org.jetbrains.annotations.NotNull;

public class FixPriceProduct extends Product {
    private final static int FIX_PRICE = 99;

    public FixPriceProduct(@NotNull String title) {
        super(title);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }
    @Override
    public String toString() {
        return getTitle() + ": Фиксированная цена " + FIX_PRICE;
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}



