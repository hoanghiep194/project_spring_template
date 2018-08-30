package jp.co.run.api.request.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductSearchRequest {

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("category_code")
    private String categoryCode;

    @JsonProperty("category_name")
    private String categoryName;

    @JsonProperty("current_page")
    private int currentPage;

    @JsonProperty("records_per_page")
    private int recordsPerPage;
}
