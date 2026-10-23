package ru.mirea.lab4;

enum Brand {
    APPLE, ASUS, LENOVO, DELL, HP
}

class Processor {
    private String model;
    private int cores;
    private double frequencyGhz;

    public Processor(String model, int cores, double frequencyGhz) {
        this.model = model;
        this.cores = cores;
        this.frequencyGhz = frequencyGhz;
    }

    @Override
    public String toString() {
        return model + " (" + cores + " ядер, " + frequencyGhz + " ГГц)";
    }
}

class Memory {
    private String type;
    private int capacityGb;

    public Memory(String type, int capacityGb) {
        this.type = type;
        this.capacityGb = capacityGb;
    }

    @Override
    public String toString() {
        return capacityGb + " ГБ " + type;
    }
}

class Monitor {
    private double diagonalInches;
    private String resolution;

    public Monitor(double diagonalInches, String resolution) {
        this.diagonalInches = diagonalInches;
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return diagonalInches + "\" (" + resolution + ")";
    }
}

class Computer {
    private Brand brand;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;

    public Computer(Brand brand, Processor processor, Memory memory, Monitor monitor) {
        this.brand = brand;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return "Компьютер " + brand + ":\n"
                + "  Процессор: " + processor + "\n"
                + "  Память:    " + memory + "\n"
                + "  Монитор:   " + monitor;
    }
}

public class ComputerApp {
    public static void main(String[] args) {
        Computer pc = new Computer(
                Brand.APPLE,
                new Processor("Apple M3 Pro", 12, 4.05),
                new Memory("LPDDR5", 18),
                new Monitor(14.2, "3024x1964")
        );
        System.out.println(pc);
    }
}