package ru.mirea.lab4_1;

public abstract class Transport {
    protected String name;
    protected double speedKmH;
    protected double passengerRatePerKm;
    protected double cargoRatePerTonKm;

    public Transport(String name, double speedKmH, double passengerRatePerKm, double cargoRatePerTonKm) {
        this.name = name;
        this.speedKmH = speedKmH;
        this.passengerRatePerKm = passengerRatePerKm;
        this.cargoRatePerTonKm = cargoRatePerTonKm;
    }

    public abstract double calculateTimeHours(double distanceKm);

    public abstract double calculatePassengerCost(double distanceKm, int passengers);

    public abstract double calculateCargoCost(double distanceKm, double weightTons);

    public void printReport(double distanceKm, int passengers, double weightTons) {
        System.out.printf("%-12s | Время в пути: %5.2f ч | Стоимость (%d пасс.): %9.2f руб. | Стоимость груза (%.1f т): %9.2f руб.%n",
                name,
                calculateTimeHours(distanceKm),
                passengers,
                calculatePassengerCost(distanceKm, passengers),
                weightTons,
                calculateCargoCost(distanceKm, weightTons));
    }
}