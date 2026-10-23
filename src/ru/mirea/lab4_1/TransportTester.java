package ru.mirea.lab4_1;

public class TransportTester {
    public static void main(String[] args) {
        Transport[] transports = {
                new Car(),
                new Airplane(),
                new Train(),
                new Ship()
        };

        double distanceKm = 1200.0;
        int passengers = 3;
        double cargoTons = 4.0;

        System.out.println("Расчет времени и стоимости перевозки на расстояние " + distanceKm + " км:");
        for (Transport transport : transports) {
            transport.printReport(distanceKm, passengers, cargoTons);
        }
    }
}