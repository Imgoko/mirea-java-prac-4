package ru.mirea.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Category {
    ELECTRONICS("Электроника"),
    BOOKS("Книги"),
    CLOTHING("Одежда");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

enum Product {
    LAPTOP(1, "Ноутбук", 75000.0, Category.ELECTRONICS),
    SMARTPHONE(2, "Смартфон", 45000.0, Category.ELECTRONICS),
    JAVA_BOOK(3, "Философия Java", 1800.0, Category.BOOKS),
    CLEAN_CODE(4, "Чистый код", 1500.0, Category.BOOKS),
    HOODIE(5, "Худи", 3500.0, Category.CLOTHING),
    SNEAKERS(6, "Кроссовки", 6200.0, Category.CLOTHING);

    private final int id;
    private final String name;
    private final double price;
    private final Category category;

    Product(int id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}

public class OnlineStoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Аутентификация в интернет-магазине ===");
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        if (login.isEmpty() || password.isEmpty()) {
            System.out.println("Ошибка аутентификации: логин и пароль не могут быть пустыми.");
            return;
        }
        System.out.println("Добро пожаловать, " + login + "!");

        List<Product> cart = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Просмотр списка каталогов товаров");
            System.out.println("2. Просмотр товаров определенного каталога");
            System.out.println("3. Добавить товар в корзину по ID");
            System.out.println("4. Купить товары в корзине");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Каталоги товаров:");
                    for (Category c : Category.values()) {
                        System.out.println((c.ordinal() + 1) + ". " + c.getTitle() + " (" + c.name() + ")");
                    }
                    break;
                case 2:
                    System.out.print("Введите номер каталога (1-" + Category.values().length + "): ");
                    int catIdx = scanner.nextInt() - 1;
                    if (catIdx >= 0 && catIdx < Category.values().length) {
                        Category selected = Category.values()[catIdx];
                        System.out.println("Товары каталога «" + selected.getTitle() + "»:");
                        for (Product p : Product.values()) {
                            if (p.getCategory() == selected) {
                                System.out.printf("ID: %d | %s — %.2f руб.%n", p.getId(), p.getName(), p.getPrice());
                            }
                        }
                    } else {
                        System.out.println("Неверный номер каталога.");
                    }
                    break;
                case 3:
                    System.out.print("Введите ID товара для добавления в корзину: ");
                    int prodId = scanner.nextInt();
                    Product found = null;
                    for (Product p : Product.values()) {
                        if (p.getId() == prodId) {
                            found = p;
                            break;
                        }
                    }
                    if (found != null) {
                        cart.add(found);
                        System.out.println("Товар «" + found.getName() + "» добавлен в корзину.");
                    } else {
                        System.out.println("Товар с таким ID не найден.");
                    }
                    break;
                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Ваша корзина пуста.");
                    } else {
                        double total = 0;
                        System.out.println("Покупка товаров из корзины:");
                        for (Product item : cart) {
                            System.out.printf("- %s: %.2f руб.%n", item.getName(), item.getPrice());
                            total += item.getPrice();
                        }
                        System.out.printf("Итого оплачено: %.2f руб. Спасибо за покупку!%n", total);
                        cart.clear();
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Некорректная команда.");
            }
        }
    }
}