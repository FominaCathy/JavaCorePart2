package gb.homework.Shop;

import gb.homework.Shop.Exception.IllegalCountException;
import gb.homework.Shop.Exception.IllegalProductException;
import gb.homework.Shop.Exception.IllegalSaleException;
import gb.homework.Shop.Shop.Product;
import gb.homework.Shop.Shop.Storage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class StorageTest {
    @Mock
    private static Product mockProduct;

    private Storage storage;

//    @BeforeAll
//    static void init() {
//        mockProduct = Mockito.mock(Product.class);
//    }

    @BeforeEach
    void createStorage() {
        storage = new Storage("storage");
    }

    @Test
    @DisplayName("first add product in storage")
    @Tag("unit-test")
    void firstAddProduct() {
        storage.addProduct(mockProduct, 10);
        assertEquals(1, storage.getStorage().size());
        assertEquals(10, storage.getStorage().get(mockProduct));
    }

    @Test
    @DisplayName("second add product in storage")
    @Tag("unit-test")
    void secondAddProduct() {
        storage.addProduct(mockProduct, 10);
        storage.addProduct(mockProduct, 2);

        assertEquals(1, storage.getStorage().size());
        assertEquals(12, storage.getStorage().get(mockProduct));
    }

    @ParameterizedTest(name = "add non-positive count product. count = {0}")
    @ValueSource(ints = {-1, 0})
    @Tag("unit-test")
    void addNegativeCount(int count) {
        String textException = "Ошибка: кол-во поступаемого товара меньше либо равна нулю";
        IllegalCountException thrown =
                assertThrows(IllegalCountException.class, () -> storage.addProduct(mockProduct, count));

        assertEquals(textException, thrown.getMessage());
    }

    @Test
    @DisplayName("sale product in storage")
    @Tag("unit-test")
    void saleProduct() {
        storage.addProduct(mockProduct, 10);
        storage.saleProduct(mockProduct, 6);
        assertEquals(4, storage.getStorage().get(mockProduct));
    }

    @Test
    @DisplayName("sale full product in storage")
    @Tag("unit-test")
    void saleFullProduct() {
        storage.addProduct(mockProduct, 10);
        storage.saleProduct(mockProduct, 10);
        assertEquals(null, storage.getStorage().get(mockProduct));
    }


    @Test
    @DisplayName("sale over remains storage")
    @Tag("unit-test")
    void saleOverStorage() {
        String textException = "Недостаточное кол-во для совершение продажи: " +
                "" + "требуется: " + "11" + ", в наличии всего: " + "10";

        storage.addProduct(mockProduct, 10);
        IllegalSaleException thrown =
                assertThrows(IllegalSaleException.class, () -> storage.saleProduct(mockProduct, 11));

        assertEquals(textException, thrown.getMessage());
    }

    @Test
    @DisplayName("sale product non-existent")
    @Tag("unit-test")
    void saleNonExistentProduct() {
        Mockito.when(mockProduct.getName()).thenReturn("name");
        String textException = "На складе нет товара с наименованием: " + mockProduct.getName();
        IllegalProductException thrown =
                assertThrows(IllegalProductException.class, () -> storage.saleProduct(mockProduct, 1));

        Mockito.verify(mockProduct, times(2)).getName();
        assertEquals(textException, thrown.getMessage());
    }


    @ParameterizedTest(name = "sale non-positive. count= {0}")
    @ValueSource(ints = {-1, 0})
    @Tag("unit-test")
    void nonPositiveSale(int count) {
        storage.addProduct(mockProduct, 10);
        String textException = "неккоректное колво. кол-во должно быть больше нуля";
        IllegalSaleException thrown =
                assertThrows(IllegalSaleException.class, () -> storage.saleProduct(mockProduct, count));

        assertEquals(textException, thrown.getMessage());
    }

    @ParameterizedTest(name = "get product valid. name= {0}")
    @ValueSource(strings = {"name", "Name", "NAME", "nAmE"})
    @Tag("unit-test")
    void getProductValid(String nameProduct) {
        storage.addProduct(mockProduct, 10);
        Mockito.when(mockProduct.getName()).thenReturn("name");
        assertEquals(mockProduct, storage.getProduct(nameProduct));
    }

}
