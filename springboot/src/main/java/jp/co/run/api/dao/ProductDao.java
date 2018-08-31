package jp.co.run.api.dao;

import java.util.List;

import jp.co.run.api.dto.product.ProductDto;
import jp.co.run.api.request.data.ProductSearchRequest;

public interface ProductDao {

    public List<ProductDto> getListProduct(final ProductSearchRequest request, final String userName) throws Exception;
}
