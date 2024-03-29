package gb.homework.Shop.Shop;

public class Order {
    private Buyer buyer;
    private Product product;
    private int count;

    public Order(Buyer buyer, Product product, int count) {
        this.buyer = buyer;
        this.product = product;
        this.count = count;

    }

    @Override
    public String toString() {
        return buyer.getLogin() + ',' + product.getName() + ',' + count;
    }
}
