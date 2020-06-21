package kata.supermarket;

import kata.supermarket.item.Item;
import kata.supermarket.item.ItemByUnit;
import kata.supermarket.product.Product;
import kata.supermarket.product.UnitProduct;
import org.junit.Test;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by s.nathan on 21/06/2020.
 */
public class BasketIntegrationTest {
    @Test
    public void test_TotalAmount_To_PaY() {
        Basket basket = getBasket();
        BigDecimal actual = basket.total();
        assertEquals(" Unexpected result ", new BigDecimal("7.00"), actual);
    }

    private Basket getBasket() {
        Basket basket = new Basket();

        Product product1 = new UnitProduct(new BigDecimal(2), 101);
        Item item1 = new ItemByUnit(product1);
        basket.add(item1);

        Product product2 = new UnitProduct(new BigDecimal(5), 102);
        Item item2 = new ItemByUnit(product2);
        basket.add(item2);

        Product product3 = new UnitProduct(new BigDecimal(2), 101);
        Item item3 = new ItemByUnit(product3);
        basket.add(item3);

        return basket;
    }
}
