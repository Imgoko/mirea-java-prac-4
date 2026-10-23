package ru.mirea.lab4;

public enum Season {
    WINTER(-10.5),
    SPRING(12.0),
    SUMMER(24.5) {
        @Override
        public String getDescription() {
            return "Теплое время года";
        }
    },
    AUTUMN(8.0);

    private final double avgTemp;

    Season(double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public String getDescription() {
        return "Холодное время года";
    }
}