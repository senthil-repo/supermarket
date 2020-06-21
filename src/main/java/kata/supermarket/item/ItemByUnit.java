package kata.supermarket.item;

import kata.supermarket.product.UnitProduct;

import java.math.BigDecimal;

public class ItemByUnit extends AbstractItem {

    public ItemByUnit(final UnitProduct product) {
        super.product = product;
        setPriceAfterDiscount(this.price());
    }

    public BigDecimal price() {
        return product.price();
    }
}
