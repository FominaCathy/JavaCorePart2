package gb.homework.Shop.Shop;

public enum UnitMeasure {
    KG ("kg"),
    LITRE ("litre"),
    BOTTLE ("bottle");

    private String title;

    UnitMeasure(String title) {
        this.title = title;
    }
}
