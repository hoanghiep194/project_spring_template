package jp.co.run.api.response.data;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jp.co.run.api.dto.product.ProductDto;
import lombok.Data;

/**
 * Instantiates a new product list response.
 */
@Data
public class ProductListResponseData {

    /** The user name. */
    @JsonProperty("user_name")
    private String userName;

    /** The role id. */
    @JsonProperty("role_id")
    private int roleId;

    /** The first name. */
    @JsonProperty("first_name")
    private String firstName;

    /** The last name. */
    @JsonProperty("last_name")
    private String lastName;

    /** The birthday. */
    @JsonProperty("birthday")
    private Date birthday;

    /** The sex. */
    @JsonProperty("sex")
    private int sex;

    /** The email address. */
    @JsonProperty("email_address")
    private String emailAddress;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The phone. */
    @JsonProperty("phone")
    private String phone;

    /** The product list. */
    @JsonProperty("product_list")
    private List<ProductResponseData> productList;
}
