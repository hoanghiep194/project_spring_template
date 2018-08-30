package jp.co.run.api.services;

import jp.co.run.api.request.data.ProductSearchRequest;
import jp.co.run.api.response.data.CommonListResponseData;

public interface ProductService {

    public CommonListResponseData getListProduct(ProductSearchRequest request) throws Exception;
}
