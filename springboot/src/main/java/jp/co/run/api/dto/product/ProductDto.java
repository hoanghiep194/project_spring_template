package jp.co.run.api.dto.product;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * Instantiates a new product list dto.
 */
@Data
public class ProductDto {

    /** The product id. */
    private String productId;

    /** The category code. */
    private String categoryCode;

    /** The category name. */
    private String categoryName;

    /** The price. */
    private BigDecimal price;

    /** The amount. */
    private int amount;

    /** The total. */
    private BigDecimal total;

    /** The regist time. */
    private Date registTime;
}
