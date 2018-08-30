package jp.co.run.api.response.data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * result_list形式で返す場合の汎用クラス。
 */
@Data
public class CommonListResponseData {

    @JsonProperty("offset")
    private int offset;

    @JsonProperty("total_count")
    private int totalCount;

    @JsonProperty("result_list")
    private List<?> resultList;

    @SuppressWarnings("rawtypes")
    public CommonListResponseData() {
        this.resultList = new ArrayList();
    }
}
