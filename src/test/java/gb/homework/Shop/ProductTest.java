package gb.homework.Shop;

import gb.homework.Shop.Exception.IllegalPriceException;
import gb.homework.Shop.Shop.Product;
import gb.homework.Shop.Shop.UnitMeasure;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {


    @ParameterizedTest(name = "create product in price = {arguments}")
    @ValueSource(doubles = {0.0, -0.1})
    @Tag("unit-test")
    void priceZeroInfo(double price) {
        String info = "Ошибка: цена товара меньше либо равно нулю";

        IllegalPriceException thrown =
                assertThrows(IllegalPriceException.class, () -> Product.create("name", UnitMeasure.KG, price));

        assertEquals(info, thrown.getMessage());
    }
}
