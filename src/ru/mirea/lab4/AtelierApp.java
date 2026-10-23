package ru.mirea.lab4;

enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private final int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    public String getDescription() {
        return "Взрослый размер";
    }
}

interface MenClothing {
    void dressMan();
}

interface WomenClothing {
    void dressWomen();
}

abstract class Clothes {
    protected Size size;
    protected double price;
    protected String color;

    public Clothes(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("размер: %s (euro %d, %s), цвет: %s, цена: %.2f руб.",
                size.name(), size.getEuroSize(), size.getDescription(), color, price);
    }
}

class TShirt extends Clothes implements MenClothing, WomenClothing {
    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская футболка — " + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женская футболка — " + this);
    }
}

class Pants extends Clothes implements MenClothing, WomenClothing {
    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужские штаны — " + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женские штаны — " + this);
    }
}

class Skirt extends Clothes implements WomenClothing {
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Юбка — " + this);
    }
}

class Tie extends Clothes implements MenClothing {
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук — " + this);
    }
}

class Atelier {
    public void dressWomen(Clothes[] clothes) {
        System.out.println("=== Женская одежда в ателье ===");
        for (Clothes item : clothes) {
            if (item instanceof WomenClothing) {
                ((WomenClothing) item).dressWomen();
            }
        }
    }

    public void dressMan(Clothes[] clothes) {
        System.out.println("=== Мужская одежда в ателье ===");
        for (Clothes item : clothes) {
            if (item instanceof MenClothing) {
                ((MenClothing) item).dressMan();
            }
        }
    }
}

public class AtelierApp {
    public static void main(String[] args) {
        Clothes[] items = {
                new TShirt(Size.M, 1990.0, "Белый"),
                new Pants(Size.L, 4500.0, "Черный"),
                new Skirt(Size.S, 3200.0, "Красный"),
                new Tie(Size.XS, 1500.0, "Синий"),
                new TShirt(Size.XXS, 990.0, "Желтый")
        };

        Atelier atelier = new Atelier();
        atelier.dressWomen(items);
        System.out.println();
        atelier.dressMan(items);
    }
}