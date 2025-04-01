package org.skypro.skyshop.basket;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.product.Product;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private final Map<String, List<Product>> basket;

    public ProductBasket() {
        basket = new HashMap<>();
        clear();
    }

    public void clear() {
        basket.clear();
    }

    public void add(@NotNull Product product) {
        List<Product> products;

        if (!basket.containsKey(product.getTitle())) {
            products = new LinkedList<>();
            basket.put(product.getTitle(), products);
        } else {
            products = basket.get(product.getTitle());
        }

        products.add(product);
    }

    @NotNull
    public List<Product> remove(@NotNull String title) {
        List<Product> removed = new LinkedList<>();
        if (basket.isEmpty()) {
            return removed;
        }

        if (basket.containsKey(title)) {
            removed = basket.remove(title);
        }
        return removed;
    }

    public int getTotalPrice() {
        return basket.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public int getSpecialProductCount() {
        return basket.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void print() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }

        basket.forEach((title, products) -> {
            System.out.println("Категория: " + title);
            products.forEach(System.out::println);
        });
    }

    public boolean contains(@NotNull String title) {
        return basket.containsKey(title);
    }
}