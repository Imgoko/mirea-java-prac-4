package ru.mirea.lab4;

public class SeasonsDemo {

    public static void printFavoriteSeasonMessage(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }

    public static void main(String[] args) {
        Season favorite = Season.SUMMER;
        System.out.println("Любимое время года: " + favorite
                + ", средняя температура: " + favorite.getAvgTemp()
                + "°C, описание: " + favorite.getDescription());

        printFavoriteSeasonMessage(favorite);

        System.out.println("\nВсе времена года:");
        for (Season s : Season.values()) {
            System.out.printf("%-8s | Ср. температура: %5.1f°C | %s%n",
                    s.name(), s.getAvgTemp(), s.getDescription());
        }
    }
}