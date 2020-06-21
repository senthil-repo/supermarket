package kata.supermarket.item;

import kata.supermarket.product.Product;

import java.math.BigDecimal;

public interface Item {
    //product & price details
    Product product();
    BigDecimal price();

    //discount details
    void setPriceAfterDiscount(BigDecimal priceAfterDiscount);
    BigDecimal getPriceAfterDiscount();
    boolean hasDiscountApplied();
    void setDiscountApplied(boolean hasDiscountApplied);
}
