package ru.mirea.lab4_1;

public class Train extends Transport {
    public Train() {
        super("Поезд", 110.0, 3.0, 10.0);
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