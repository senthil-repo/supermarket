package kata.supermarket.item;

import kata.supermarket.item.Item;
import kata.supermarket.product.Product;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final Product product;

    ItemByUnit(final Product product) {
        this.product = product;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }
}
