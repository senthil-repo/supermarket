package kata.supermarket;

import kata.supermarket.discount.DiscountProcessor;
import kata.supermarket.item.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private final List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

/*    public void add(final Item item) {
        this.items.add(item);
    }*/

    public List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        //Before discount
        TotalCalculator totalCalculator = new TotalCalculator();
        System.out.println(" Total price before discount "+totalCalculator.subtotal());

        //After discount
        DiscountProcessor discountProcessor = new DiscountProcessor();
        discountProcessor.processDiscounts(this);

        BigDecimal finalPrice = totalCalculator.calculate();
        System.out.println(" Total price after discount "+finalPrice);

        return finalPrice;
    }

    private class TotalCalculator {
        private final List<Item> items;

        TotalCalculator() {
            this.items = items();
        }

        private BigDecimal subtotal() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        private BigDecimal subtotal_DiscountPrice() {
            BigDecimal discountPrice = items.stream().filter(item -> item.hasDiscountApplied()).map(Item::getPriceAfterDiscount)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
            System.out.println(" Discount price "+discountPrice);
            return discountPrice;
        }

        /**
         * TODO: This could be a good place to apply the results of
         *  the discount calculations.
         *  It is not likely to be the best place to do those calculations.
         *  Think about how Basket could interact with something
         *  which provides that functionality.
         */
        private BigDecimal discounts() {
            return BigDecimal.ZERO;
        }

        private BigDecimal calculate() {
            return subtotal().subtract(subtotal_DiscountPrice());
        }
    }
}
