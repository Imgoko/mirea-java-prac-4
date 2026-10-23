package ru.mirea.lab4_1;

public class Ship extends Transport {
    public Ship() {
        super("Корабль", 40.0, 2.5, 5.0);
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