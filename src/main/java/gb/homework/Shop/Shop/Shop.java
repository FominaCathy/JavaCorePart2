package gb.homework.Shop.Shop;

import gb.homework.Shop.Exception.IllegalBuyerException;
import gb.homework.Shop.Exception.ShopException;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private static Storage storage;
    private static List<Buyer> buyers;

    public Shop(String name, Storage storage) {
        this.name = name;
        Shop.storage = storage;
        Shop.buyers = new ArrayList<>();
    }

    public static Order sale(Buyer buyer, Product product, int count) throws ShopException {
        storage.saleProduct(product, count);
        return new Order(buyer, product, count);
    }

    public static Buyer getBuyersByLogin(String login){
        List<Buyer> res = buyers.stream().filter(x ->x.getLogin().equals(login)).toList();
        if (res.isEmpty()){
            throw new IllegalBuyerException(login);
        }
        return res.get(0);
    }

    public static Storage getStorage() {
        return storage;
    }

    public static List<Buyer> getBuyers() {
        return buyers;
    }

    public String getName() {
        return name;
    }
}
