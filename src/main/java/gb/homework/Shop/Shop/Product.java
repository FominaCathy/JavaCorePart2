package gb.homework.Shop.Shop;

import gb.homework.Shop.Exception.IllegalPriceException;


public class Product {
    private String name;
    private UnitMeasure unitMeasure;
    private double price;

    private Product(String name, UnitMeasure unitMeasure, double price) {
        this.name = name;
        this.unitMeasure = unitMeasure;
        this.price = price;
    }

    public static Product create(String name, UnitMeasure unitMeasure, double price) {

        if (price <= 0.0) {
            throw new IllegalPriceException("Ошибка: цена товара меньше либо равно нулю");
        }
        return new Product(name, unitMeasure, price);
    }

    public String getName() {
        return name;
    }

    public UnitMeasure getUnitMeasure() {
        return unitMeasure;
    }

    public double getPrice() {
        return price;
    }
}
