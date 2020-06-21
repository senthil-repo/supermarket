package kata.supermarket.product;

import java.math.BigDecimal;

public class WeighedProduct extends Product {

    private final BigDecimal pricePerKilo;
    private final int productID;

    public WeighedProduct(final BigDecimal pricePerKilo, final int productID) {
        this.pricePerKilo = pricePerKilo;
        this.productID = productID;
    }

    private BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

/*
    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
*/

    @Override
    public BigDecimal price() {
        return pricePerKilo();
    }

    @Override
    public int productID() {
        return this.productID;
    }
}
