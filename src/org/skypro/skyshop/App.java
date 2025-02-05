package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;


public class App {
    public static void main(String[] args) {

        Product product1 = new SimpleProduct("Молоко", 80);
        Product product2 = new FixPriceProduct("Хлеб");
        Product product3 = new FixPriceProduct("Сыр");
        Product product4 = new DiscountProduct("Масло", 400, 20);
        Product product5 = new DiscountProduct("Яйца", 140, 10);
        Product product6 = new SimpleProduct("Мясо", 900);
        Product product7 = new SimpleProduct("Бластер", 200);


        var basket = new ProductBasket();


        System.out.println("Заполнение корзины...");
        basket.add(product1);
        basket.add(product2);
        basket.add(product3);
        basket.add(product4);
        basket.add(product5);
        System.out.println("Заполнена");


        basket.print();


        int price = basket.getTotalPrice();
        System.out.println("Итого: " + price);


        int specialProductCount = basket.getSpecialProductCount();
        System.out.println("Специальных товаров: " + specialProductCount);

        System.out.println();


        boolean exists = basket.contains(product1.getTitle());
        System.out.println("Товар " + product1.getTitle() + " есть в корзине: " + exists);


        exists = basket.contains(product7.getTitle());
        System.out.println("Товар " + product7.getTitle() + " есть в корзине: " + exists);

        System.out.println();


        System.out.println("Очистка корзины...");
        basket.clear();
        System.out.println("Корзина очищена");
        System.out.println();


        basket.print();


        price = basket.getTotalPrice();
        System.out.println("Стоимость пустой корзины: " + price);


        specialProductCount = basket.getSpecialProductCount();
        System.out.println("Специальных товаров в пустой корзине: " + specialProductCount);

        System.out.println();



        System.out.println("Создание SimpleProduct с неверным названием...");
        try {
            @SuppressWarnings("unused")
            Product product8 = new SimpleProduct("  ", 1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        System.out.println("Создание SimpleProduct с неверной ценой...");
        try {
            @SuppressWarnings("unused")
            Product product8 = new SimpleProduct("Продукт №8", 0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        System.out.println("Создание DiscountedProduct с неверным названием...");
        try {
            @SuppressWarnings("unused")
            Product product8 = new DiscountProduct("  ", 1, 0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        System.out.println("Создание DiscountedProduct с неверной ценой...");
        try {
            @SuppressWarnings("unused")
            Product product8 = new DiscountProduct("Продукт №8", 0, 0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        System.out.println("Создание DiscountedProduct с неверной скидкой...");
        try {
            @SuppressWarnings("unused")
            Product product8 = new DiscountProduct("Продукт №8", 1, -1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        System.out.println();



        System.out.println();


        System.out.println("Заполнение корзины. Ещё раз...");
        basket.add(product1);
        basket.add(product2);
        basket.add(product3);
        basket.add(product4);
        basket.add(product5);
        basket.add(product6);
        basket.add(product7);

        basket.print();
    }
}