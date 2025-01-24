package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    private static ProductBasket basket;

    public static void main(String[] args) {
        Product product1 = new Product("Курица", 500);
        Product product2 = new Product("Хлеб", 60);
        Product product3 = new Product("Сельдерей", 210);
        Product product4 = new Product("Ролл", 380);
        Product product5 = new Product("Огурец", 170);
        Product product6 = new Product("Шоколадка", 200);
        Product product7 = new Product("Кроссворд", 450);


        var basket = new ProductBasket();
        basket.print();
        basket.add(product1);
        basket.add(product2);
        basket.add(product3);
        basket.add(product4);
        basket.add(product5);
        basket.print();
        // Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.add(product6);
        // Печать содержимого корзины с несколькими товарами.
        basket.print();

        // Получение стоимости корзины с несколькими товарами.
        int price = basket.getTotalPrice();
        System.out.println("Стоимость корзины с несколькими товарами: " + price);

        // Поиск товара, который есть в корзине.
        boolean exists = basket.contains(product1.getTitle());
        System.out.println("Товар " + product1.getTitle() + " есть в корзине: " + exists);

        // Поиск товара, которого нет в корзине.
        exists = basket.contains(product7.getTitle());
        System.out.println("Товар " + product7.getTitle() + " есть в корзине: " + exists);

        // Очистка корзины.
        basket.clear();

        // Печать содержимого пустой корзины.
        basket.print();

        // Получение стоимости пустой корзины.
        price = basket.getTotalPrice();
        System.out.println("Стоимость пустой корзины: " + price);

        // Поиск товара по имени в пустой корзине.
        exists = basket.contains(product1.getTitle());
        System.out.println("Товар " + product1.getTitle() + " есть в корзине: " + exists);
    }
}
