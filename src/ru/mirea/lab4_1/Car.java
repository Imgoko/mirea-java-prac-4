package ru.mirea.lab4_1;

public class Car extends Transport {
    public Car() {
        super("Автомобиль", 90.0, 4.5, 25.0);
    }

    @Override
    public double calculateTimeHours(double distanceKm) {
        return distanceKm / speedKmH;
    }

    @Override
    public double calculatePassengerCost(double distanceKm, int passengers) {
        return distanceKm * passengerRatePerKm * passengers;
    }

    @Override
    public double calculateCargoCost(double distanceKm, double weightTons) {
        return distanceKm * cargoRatePerTonKm * weightTons;
    }
}