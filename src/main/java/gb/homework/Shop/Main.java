package gb.homework.Shop;

import gb.homework.Shop.Exception.ShopException;
import gb.homework.Shop.Shop.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String nameFile;
    private static List<Order> sales;
    private static int counter;

    public static void main(String[] args) {
        nameFile = "sales.txt";
        File file = new File(nameFile);
        file.delete();
        counter = 0;

        Shop myShop = new Shop("myShop", new Storage("myStorage"));
        Shop.getStorage().addProduct(Product.create("milk", UnitMeasure.LITRE, 1.0), 20);
        Shop.getStorage().addProduct(Product.create("cheese", UnitMeasure.KG, 12.0), 10);
        Shop.getStorage().addProduct(Product.create("coffee", UnitMeasure.BOTTLE, 7.5), 15);
        Shop.getStorage().addProduct(Product.create("apple", UnitMeasure.KG, 0.5), 30);
        Shop.getStorage().addProduct(Shop.getStorage().getProduct("cheese"), 2);

        Buyer catTom = new Buyer("CatTom", "Cat", "Tom", Gender.MALE);
        Buyer mouseLulu = new Buyer("MouseLulu", "Mouse", "Lulu", Gender.FEMALE);
        Shop.getBuyers().add(catTom);
        Shop.getBuyers().add(mouseLulu);

        //продажи
        addSales("CatTom", "molk", 10); //некорректное наим
        addSales("CatTom", "milk", 10);
        addSales("CatTom", "milk", -10); //некорректное кол-во
        addSales("MouseLulu", "milk", 30); //превышающее кол-во
        addSales("MouseLulu", "cheese", 10);
        addSales("CatTom", "cheese", 2);
        addSales("MouseLulu", "coffee", 1);
        addSales("Lulu", "coffee", 1); // некорректный логин
        addSales("CatTom", "cheese", 1); //уже нет на складе такого товара.

        System.out.println("выполнено продаж: " + counter);
    }

    private static void addSales(String buyer, String name, int count) {
        try {
            // sales.add(Shop.sale(Shop.getBuyersByLogin(buyer), Shop.getStorage().getProduct(name), count));
            saveInFile(Shop.sale(Shop.getBuyersByLogin(buyer), Shop.getStorage().getProduct(name), count));
            counter ++;
        } catch (ShopException ex) {
            System.out.println("ошибка продажи " + name + " : " + ex.getMessage());
        }
    }

    private static void saveInFile(Order order) {

        try (FileWriter fileOrder = new FileWriter(nameFile, true)) {
            fileOrder.write(order.toString() + "\n");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
