package jp.co.run.api.response.data;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Instantiates a new product response data.
 */
@Data
public class ProductResponseData {

    /** The product id. */
    @JsonProperty("product_id")
    private String productId;

    /** The category code. */
    @JsonProperty("category_code")
    private String categoryCode;

    /** The category name. */
    @JsonProperty("category_name")
    private String categoryName;

    /** The price. */
    @JsonProperty("price")
    private BigDecimal price;

    /** The amount. */
    @JsonProperty("amount")
    private int amount;

    /** The total. */
    @JsonProperty("total")
    private BigDecimal total;

    /** The regist time. */
    @JsonProperty("regist_time")
    private Date registTime;
}
