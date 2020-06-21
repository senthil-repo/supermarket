package kata.supermarket.item;

import kata.supermarket.product.UnitProduct;

import java.math.BigDecimal;

public class ItemByWeight extends AbstractItem  {

    private final UnitProduct product;
    private final BigDecimal weightInKilos;

    public ItemByWeight(final UnitProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    @Override
    public UnitProduct product() {
        return this.product;
    }

    @Override
    public BigDecimal price() {
        return product.price().multiply(weightInKilos).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
