package kata.supermarket.discount.scheme;

import kata.supermarket.Basket;
import kata.supermarket.discount.DiscountRule;
import kata.supermarket.product.Product;

import java.util.List;

/**
 * Created by s.nathan on 21/06/2020.
 */
public class Discount_BuyKGForHalfPriceSingle implements DiscountRule {

    List<Product> eligibleProductList;

    public Discount_BuyKGForHalfPriceSingle(List<Product> productList) {
        this.eligibleProductList = productList;
    }
    @Override
    public String ruleName() {
        return "Discount_BuyKGForHalfPrice";
    }

    @Override
    public void applyDiscount(Basket basket) {
        // To be implemented in future
    }
}
