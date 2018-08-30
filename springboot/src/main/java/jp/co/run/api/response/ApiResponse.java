package jp.co.run.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize
public class ApiResponse {

    private Integer status;
    private String type;
    private String description;
    @JsonProperty("description_sub")
    private String descriptionSub;

    @JsonProperty("result_data")
    private Object resultData;
}
