package kata.supermarket.discount.scheme;

import kata.supermarket.Basket;
import kata.supermarket.discount.DiscountRule;
import kata.supermarket.item.Item;
import kata.supermarket.product.Product;

import java.math.BigDecimal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by s.nathan on 21/06/2020.
 */
public class Discount_BuyOneGetOneSingle implements DiscountRule {

    List<Product> eligibleProductList;

    public Discount_BuyOneGetOneSingle(List<Product> productList) {
        this.eligibleProductList = productList;
    }

    @Override
    public String ruleName() {
        return "Discount_BuyOneGetOneSingle";
    }

    /**
     * Following logic applied:
     *  - Check the eligibility -
     *
     * @param basket
     */
    @Override
    public void applyDiscount(Basket basket) {
        List<Item> itemListToApplyDiscount = basket.items().stream().filter(item -> isItemEligibleForThisOffer(item)).collect(Collectors.toList());
        if(itemListToApplyDiscount.size() < 2) //Minimum 2 items should be there to avail this offer
            return;

        //offer can be applied only up-to the maximum number of even quantities
        //E.g - for a list of 5 items, only 4 can be considered for discount. The remaining one has to be fully paid
        int itemListSize = itemListToApplyDiscount.size();
        List<Item> itemListToApplyNewPrice = itemListToApplyDiscount.subList(0, itemListSize/2);

        //price change to respective items
        itemListToApplyNewPrice.forEach(item -> {
            item.setPriceAfterDiscount(new BigDecimal(0.0));
        });
        //update flag to indicate discount has applied
        itemListToApplyDiscount.forEach(item -> {
            item.setDiscountApplied(true);
        });
    }

    /**
     * ********** This can be extended in future to accomodate multiple offer applicability **********
     * If discount is already applied, do not offer again.
     * @param item
     * @return
     */
    private boolean isItemEligibleForThisOffer(Item item) {
        return !item.hasDiscountApplied() && eligibleProductList.stream().anyMatch(product -> product.productID() == item.product().productID());
    }
}
