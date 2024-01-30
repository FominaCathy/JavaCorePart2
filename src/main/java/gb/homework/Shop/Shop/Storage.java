package gb.homework.Shop.Shop;

import gb.homework.Shop.Exception.IllegalCountException;
import gb.homework.Shop.Exception.IllegalProductException;
import gb.homework.Shop.Exception.IllegalSaleException;

import java.util.HashMap;
import java.util.List;

public class Storage {
    private String nameStorage;
    private HashMap<Product, Integer> storage;

    public Storage(String nameStorage) {
        this.nameStorage = nameStorage;
        this.storage = new HashMap<>();
    }

    /**
     * добавление товара на склад
     *
     * @param product - товар
     * @param count-  кол-во, добавляемое на склад (если товар уже есть на складе - то кол-во его увеличивается,
     *                если нет - добавляется новая строка
     */
    public void addProduct(Product product, int count) {
        if (count <= 0) {
            throw new IllegalCountException("Ошибка: кол-во поступаемого товара меньше либо равна нулю");
        }
        if (storage.containsKey(product)) {
            int currentCount = storage.get(product);
            this.storage.put(product, currentCount + count);
        } else {
            this.storage.put(product, count);
        }
    }

    /**
     * продажа  товара со склада
     *
     * @param product - товар
     * @param count-  количество проданного товара, на которое умненьшается остаток.
     *                если товар продается "под ноль" - строка полностью удаляется из мапы
     */
    public void saleProduct(Product product, int count) {
        if (!this.storage.containsKey(product)) {
            throw new IllegalProductException(product.getName());
        }

        if (count > this.storage.get(product)) {
            throw new IllegalSaleException(this.storage.get(product), count);
        }
        if (count <= 0) {
            throw new IllegalSaleException("неккоректное колво. кол-во должно быть больше нуля");
        }

        if (count == this.storage.get(product)) {
            this.storage.remove(product);
        } else {
            int currentCount = storage.get(product);
            this.storage.put(product, currentCount - count);
        }

    }

    public Product getProduct(String nameProduct) {

        List<Product> products =
                storage.keySet().stream()
                        .filter(x -> x.getName().equalsIgnoreCase(nameProduct))
                        .toList();

        if (products.isEmpty()) {
            throw new IllegalProductException(nameProduct);
        }
        return products.get(0);
    }
}
