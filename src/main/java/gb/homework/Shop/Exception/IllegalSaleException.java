package gb.homework.Shop.Exception;

public class IllegalSaleException extends ShopException {
    public IllegalSaleException(int factCount, int needCount) {

        super("Недостаточное кол-во для совершение продажи: " +
                "" + "требуется: " + needCount + ", в наличии всего: " + factCount);

    }
    public IllegalSaleException(String message){
        super(message);
    }

}
