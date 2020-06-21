package kata.supermarket.product;

import kata.supermarket.item.ItemByWeight;
import kata.supermarket.item.Item;

import java.math.BigDecimal;

public class WeighedProduct {

    private final BigDecimal pricePerKilo;

    public WeighedProduct(final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        //return new ItemByWeight(this, kilos);
        return null;
    }
}
