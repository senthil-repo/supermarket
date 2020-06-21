package kata.supermarket.product;

import java.math.BigDecimal;

/**
 * Created by s.nathan on 21/06/2020.
 */
public abstract class Product {
    abstract public BigDecimal price();
    abstract public int productID();
}
