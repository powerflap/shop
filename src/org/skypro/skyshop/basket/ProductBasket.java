package org.skypro.skyshop.basket;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    public static final int MAX_PRODUCTS = 5;

    public static final int NOT_FOUND = -1;

    private final Product[] products;

    public ProductBasket() {
        products = new Product[MAX_PRODUCTS];
        clear();
    }

    public void clear() {
        Arrays.fill(products, null);
    }


    private int getFirstFreeIndex() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    public void add(@NotNull Product product) {
        int freeIndex = getFirstFreeIndex();
        if (freeIndex == NOT_FOUND) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[freeIndex] = product;
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    private int getProductCount() {
        int count = 0;
        for (Product product : products) {
            if (product != null) {
                count++;
            }
        }
        return count;
    }

    public void print() {
        if (getProductCount() <= 0) {
            System.out.println("в корзине пусто");
            return;
        }

        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getTitle() + ": " + product.getPrice());
            }
        }
    }

    public boolean contains(@NotNull String title) {
        for (Product product : products) {
            if (product != null) {
                if (product.getTitle().equals(title)) {
                    return true;
                }
            }
        }
        return false;

    }
}
