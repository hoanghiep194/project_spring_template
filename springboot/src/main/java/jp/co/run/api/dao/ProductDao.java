package jp.co.run.api.dao;

import java.util.List;

import jp.co.run.api.dto.product.ProductListDto;
import jp.co.run.api.request.data.ProductSearchRequest;

public interface ProductDao {

    public List<ProductListDto> getListProduct(ProductSearchRequest request) throws Exception;
}
