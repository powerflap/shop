package org.skypro.skyshop.basket;
import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    public static final int MAX_PRODUCTS = 5;

    /**
     * Универсальный признак "не найдено".
     */
    public static final int NOT_FOUND = -1;

    /**
     * Реализация хранилища товаров.
     */
    private final Product[] products;

    /**
     * Конструктор.
     */
    public ProductBasket() {
        products = new Product[MAX_PRODUCTS];
        clear();
    }

    /**
     * Очистка корзины.
     */
    public void clear() {
        Arrays.fill(products, null);
    }

    /**
     * Получение первой от нуля свободной или занятой ячейки в хранилище.
     *
     * @return индекс свободной ячейки или {@link #NOT_FOUND}
     */
    private int getFirstFreeIndex() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {   return i;
            }
        }
        return NOT_FOUND;
    }
    /**
     * Добавление товара в корзину.
     *
     * @param product добавляемый товар
     */
    public void add(@NotNull Product product) {
        int freeIndex = getFirstFreeIndex();
        if (freeIndex == NOT_FOUND) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[freeIndex] = product;
    }
    /**
     * Получение общей стоимости корзины.
     *
     * @return общая стоимость корзины
     */
    public int getTotalPrice() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }
    /**
     * Получение количества товаров в корзине.
     *
     * @return количество товаров в корзине
     */
    private int getProductCount() {
        int count = 0;
        for (Product product : products) {
            if (product != null) {
                count++;
            }
        }
        return count;
    }
    /**
     * Печать корзины.
     */
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
    /**
     * Проверка наличия товара в корзине.
     *
     * @param title название товара
     * @return true если товар есть в корзине
     */
    public boolean contains(@NotNull String title) {
        for (Product product : products) {
            if (product != null) {
                if (product.getTitle().equals(title)) {
                    return true;
                }
            }
        }
        return false;

}}
