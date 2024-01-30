package gb.homework.Shop.Exception;

public class IllegalBuyerException extends ShopException {

    public IllegalBuyerException(String loginBuyer) {
        super("пользователь с логином \'" + loginBuyer + "\' - не найден");
    }


}
