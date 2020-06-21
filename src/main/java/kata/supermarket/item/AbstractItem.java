package kata.supermarket.item;
import kata.supermarket.product.UnitProduct;

import java.math.BigDecimal;

/**
 * Created by s.nathan on 21/06/2020.
 */
public abstract class AbstractItem implements Item{
    BigDecimal priceAfterDiscount;
    boolean hasDiscountApplied;
    UnitProduct product;

    @Override
    public void setPriceAfterDiscount(BigDecimal priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    @Override
    public BigDecimal getPriceAfterDiscount() {
        return (this.priceAfterDiscount == null ? this.product().price() : this.priceAfterDiscount);
    }

    @Override
    public boolean hasDiscountApplied() {
        return this.hasDiscountApplied;
    }

    @Override
    public void setDiscountApplied(boolean hasDiscountApplied) {
        this.hasDiscountApplied = hasDiscountApplied;
    }

    @Override
    public UnitProduct product() {
        return this.product;
    }
}
