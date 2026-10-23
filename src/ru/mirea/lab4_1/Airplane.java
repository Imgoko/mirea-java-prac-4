package ru.mirea.lab4_1;

public class Airplane extends Transport {
    public Airplane() {
        super("Самолет", 850.0, 12.0, 120.0);
    }

    @Override
    public double calculateTimeHours(double distanceKm) {
        // Учитываем 0.5 часа на взлет и посадку
        return (distanceKm / speedKmH) + 0.5;
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