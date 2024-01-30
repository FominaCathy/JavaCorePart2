package gb.homework.Shop.Exception;

import gb.homework.Shop.Shop.Product;

public class IllegalProductException extends ShopException {

    public IllegalProductException(String productName) {
        super("На складе нет товара с наименованием: " + productName);
    }


}
