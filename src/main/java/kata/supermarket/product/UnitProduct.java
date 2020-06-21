package kata.supermarket.product;

import java.math.BigDecimal;

import java.math.BigDecimal;

public class UnitProduct extends Product {

    private final BigDecimal pricePerUnit;
    private final int productID;

    public  UnitProduct(final BigDecimal pricePerUnit, final int productID) {
        this.pricePerUnit = pricePerUnit;
        this.productID = productID;
    }

    private BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

/*
    public Item oneOf() {
        return new ItemByUnit(this);
    }
*/

    @Override
    public BigDecimal price() {
        return pricePerUnit();
    }

    @Override
    public int productID() {
        return this.productID;
    }
}
