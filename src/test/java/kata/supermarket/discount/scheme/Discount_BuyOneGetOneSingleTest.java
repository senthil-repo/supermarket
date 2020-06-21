package kata.supermarket.discount.scheme;

import kata.supermarket.Basket;
import kata.supermarket.item.Item;
import kata.supermarket.item.ItemByUnit;
import kata.supermarket.product.Product;
import kata.supermarket.product.UnitProduct;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by s.nathan on 21/06/2020.
 */
public class Discount_BuyOneGetOneSingleTest {
    Discount_BuyOneGetOneSingle butOneGetOne;
    Basket basket;

    @Before
    public void setUp() {
        butOneGetOne = new Discount_BuyOneGetOneSingle(getEligibleProductList());
    }

    @Test
    public void testApplyDiscount() {
        basket = getBasket();
        butOneGetOne.applyDiscount(basket);

        BigDecimal actualPrice = basket.items().stream().map(Item::getPriceAfterDiscount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        assertEquals(" Wrong price ", new BigDecimal(2.00), actualPrice);
    }

    @Test
    public void testApplyDiscount_Already_Applied() {
        basket = getBasket_Already_Applied();
        butOneGetOne.applyDiscount(basket);

        BigDecimal actualPrice = basket.items().stream().map(Item::getPriceAfterDiscount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        assertEquals(" Wrong price ", new BigDecimal(4.00), actualPrice);
    }

    @Test
    public void testApplyDiscount_Product_NotEligible() {
        basket = getBasket_Product_NotEligible();
        butOneGetOne.applyDiscount(basket);
        boolean actualResult = basket.items().stream().noneMatch(Item::hasDiscountApplied);
        assertTrue(" Invalid result ", actualResult);
    }

    @Test
    public void testApplyDiscount_Quantity_NotEligible() {
        basket = getBasket_Quantity_NotEligible();
        butOneGetOne.applyDiscount(basket);

        boolean actualResult = basket.items().stream().noneMatch(Item::hasDiscountApplied);
        assertTrue(" Invalid result ", actualResult);
        BigDecimal actualPrice = basket.items().stream().map(Item::getPriceAfterDiscount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        assertEquals(" Wrong price ", new BigDecimal(3.00), actualPrice);
    }

    @Test
    public void testApplyDiscount_Odd_Quantity() {
        basket = getBasket_Odd_Quantity();
        butOneGetOne.applyDiscount(basket);

        BigDecimal actualPrice = basket.items().stream().map(Item::getPriceAfterDiscount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        assertEquals(" Wrong price ", new BigDecimal(6.00), actualPrice);
    }


    private static List<Product> getEligibleProductList() {
        List<Product> productList = new ArrayList<>();
        Product product1 = new UnitProduct(new BigDecimal(0.0), 101);
        productList.add(product1);
        Product product2 = new UnitProduct(new BigDecimal(0.0), 109);
        productList.add(product2);

        return productList;
    }

    private Basket getBasket() {
        Basket basket = new Basket();

        Product product1 = new UnitProduct(new BigDecimal(2), 101);
        Item item1 = new ItemByUnit(product1);
        basket.add(item1);

        Product product2 = new UnitProduct(new BigDecimal(2), 101);
        Item item2 = new ItemByUnit(product2);
        basket.add(item2);

        return basket;
    }

    private Basket getBasket_Already_Applied() {
        Basket basket = new Basket();

        Product product1 = new UnitProduct(new BigDecimal(2), 101);
        Item item1 = new ItemByUnit(product1);
        item1.setDiscountApplied(true);
        basket.add(item1);

        Product product3 = new UnitProduct(new BigDecimal(2), 101);
        Item item3 = new ItemByUnit(product3);
        basket.add(item3);

        return basket;
    }

    private Basket getBasket_Product_NotEligible() {
        Basket basket = new Basket();

        Product product1 = new UnitProduct(new BigDecimal(3), 110);
        Item item1 = new ItemByUnit(product1);
        basket.add(item1);

        Product product2 = new UnitProduct(new BigDecimal(4), 111);
        Item item2 = new ItemByUnit(product2);
        basket.add(item2);

        return basket;
    }

    private Basket getBasket_Quantity_NotEligible() {
        Basket basket = new Basket();

        Product product1 = new UnitProduct(new BigDecimal(3), 101);
        Item item1 = new ItemByUnit(product1);
        basket.add(item1);

        return basket;
    }

    private Basket getBasket_Odd_Quantity() {
        Basket basket = new Basket();

        Product product1 = new UnitProduct(new BigDecimal(3), 101);
        Item item1 = new ItemByUnit(product1);
        basket.add(item1);

        Product product2 = new UnitProduct(new BigDecimal(3), 101);
        Item item2 = new ItemByUnit(product2);
        basket.add(item2);

        Product product3 = new UnitProduct(new BigDecimal(3), 101);
        Item item3 = new ItemByUnit(product3);
        basket.add(item3);

        return basket;
    }
}
