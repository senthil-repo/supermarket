package kata.supermarket.discount;

import kata.supermarket.Basket;

/**
 * Created by s.nathan on 21/06/2020.
 */
public interface DiscountRule {
    String ruleName();
    void applyDiscount(Basket basket);
}
