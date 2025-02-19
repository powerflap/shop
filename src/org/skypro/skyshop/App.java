package org.skypro.skyshop;


import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searcheble.BestResultNotFound;
import org.skypro.skyshop.searcheble.SearchEngine;
import org.skypro.skyshop.searcheble.Searchable;


public class App {
    public static void main(String[] args) {

        Product product1 = new SimpleProduct("Молоко", 80);
        Product product2 = new FixPriceProduct("Хлеб");
        Product product3 = new FixPriceProduct("Сыр");
        Product product4 = new DiscountProduct("Масло", 400, 20);
        Product product5 = new DiscountProduct("Яйца", 140, 10);
        Product product6 = new SimpleProduct("Мясо", 900);
        Product product7 = new SimpleProduct("водяной пистолет", 200);


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

    Article article1 = new Article ("У нас в магазине только сегодня,",
            "только в данный момент, " +
                    "продается Водяной пистолет ");

    Article article2 = new Article("Внимание!",
            "В третьем отделе нашего интернет магазина " +
                    "пропал ребенок! " +
                    "Кто найдет -  " +
                    "забирайте");

    Article article3 = new Article("Да,",
            "У нас дороже, чем в других магазинах, " +
                    "но вы, всеравно покупаете");

    Article article4 = new Article("В пятницу в отделе мяса будет проходить",
            "мощнейшая рейв вечеринка! " +
                    "Вход свободный. 14+");



    SearchEngine searchEngine = new SearchEngine();

        System.out.println("Заполнение движка поиска...");
        searchEngine = new SearchEngine();
        searchEngine.add((Searchable) product1);
        searchEngine.add((Searchable) product2);
        searchEngine.add((Searchable) product3);
        searchEngine.add((Searchable) product4);
        searchEngine.add((Searchable) product5);
        searchEngine.add((Searchable) product6);
        searchEngine.add((Searchable) product7);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        System.out.println("Заполнен");

        String query = "Молоко";
        var searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + ArrayTools.toString(searchResults));

        query = "молоко";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + ArrayTools.toString(searchResults));

        query = "Водяной пистолет";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + ArrayTools.toString(searchResults));

        query = "мясо";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + ArrayTools.toString(searchResults));

        System.out.println();

        query = "сыр";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + '\n' + ArrayTools.toString(searchResults));

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
        Searchable bestResult;

        query = "вечеринка";
        System.out.println("Поиск лучшего результата для " + query + "...");
        try {
            bestResult = searchEngine.searchMostFrequent(query);
            System.out.println("Результаты поиска " + query + ": " + bestResult);
        } catch (BestResultNotFound ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        query = "пропал ребенок";
        System.out.println("Поиск лучшего результата для " + query + "...");
        try {
            bestResult = searchEngine.searchMostFrequent(query);
            System.out.println("Результаты поиска " + query + ": " + bestResult);
        } catch (BestResultNotFound ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        System.out.println();


        System.out.println("Заполнение корзины. Ещё раз...");
        basket.add(product1);
        basket.add(product2);
        basket.add(product3);
        basket.add(product4);
        basket.add(product5);
        basket.add(product6);
        basket.add(product7);


        query = "Молоко";
        System.out.println("Удаляем продукт " + query + " из корзины...");
        var removedProducts = basket.remove(query);


        System.out.println("Удаленные продукты: ");
        for (var product : removedProducts) {
            System.out.println(product);
        }

        System.out.println();

        basket.print();

        System.out.println();


        query = "Жигулевское охлажденное";
        System.out.println("Удаляем несуществующий продукт " + query + " из корзины...");
        removedProducts = basket.remove(query);


        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Список не пуст!");
        }

        System.out.println();


        basket.print();
    }
}