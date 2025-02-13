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

        if (basket.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (String title : basket.keySet()) {
            List<Product> products = basket.get(title);
            for (Product product : products) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public int getSpecialProductCount() {
        if (basket.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (String title : basket.keySet()) {
            List<Product> products = basket.get(title);
            for (Product product : products) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }


    @SuppressWarnings("unused")
    private int getProductCount() {
        if (basket.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (String title : basket.keySet()) {
            List<Product> products = basket.get(title);
            count += products.size();
        }
        return count;
    }


    public void print() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        for (String title : basket.keySet()) {
            List<Product> products = basket.get(title);
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }


    public boolean contains(@NotNull String title) {
        return basket.containsKey(title);
    }
}
