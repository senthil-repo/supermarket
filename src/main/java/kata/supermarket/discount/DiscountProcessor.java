package kata.supermarket.discount;

import kata.supermarket.Basket;
import kata.supermarket.discount.scheme.Discount_BuyKGForHalfPriceSingle;
import kata.supermarket.discount.scheme.Discount_BuyOneGetOneSingle;
import kata.supermarket.product.Product;
import kata.supermarket.product.UnitProduct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by s.nathan on 21/06/2020.
 */
public class DiscountProcessor {
    public void processDiscounts(Basket basket) {

        //Load all applicable discount rules
        List<DiscountRule> discountRuleList = getDiscountRule();

        //apply discounts
        discountRuleList.forEach(discountRule -> discountRule.applyDiscount(basket));
    }

    private List<DiscountRule> getDiscountRule() {
        List<DiscountRule> discountRuleList = new ArrayList<>();

        DiscountRule discountRule = null;
        //BUY1GET1_SINGLE
        /**
         * Person who creates the should attach the products that are eligible for that rule.
         */
        discountRule = new Discount_BuyOneGetOneSingle(getProductListForBuy1Get1());
        discountRuleList.add(discountRule);

        //BUY1GET1_MIX
        //discountRule = new Discount_BuyOneGetOneMix();
        //discountRuleList.add(discountRule);

        //BUYKGFORHALFPRICE_SINGLE
        discountRule = new Discount_BuyKGForHalfPriceSingle(getProductListForBuyKGForHalfPrice());
        discountRuleList.add(discountRule);

        return discountRuleList;
    }

    /**
     * ********** Ideally this would be configured outside and passed here **********
     * Products that are eligible for Buy One Get One Free offer
     * @return
     */
    private List<Product> getProductListForBuy1Get1() {
        List<Product> productList = new ArrayList<>();
        Product product1 = new UnitProduct(new BigDecimal(0.0), 101);
        productList.add(product1);
        Product product2 = new UnitProduct(new BigDecimal(0.0), 121);
        productList.add(product2);

        return productList;
    }

    /**
     * Products that are eligible for Buy One Get One Free offer
     * @return
     */
    private List<Product> getProductListForBuyKGForHalfPrice() {
        return new ArrayList<>();
    }
}
