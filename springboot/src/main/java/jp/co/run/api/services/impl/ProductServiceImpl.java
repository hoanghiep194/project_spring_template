package jp.co.run.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.run.api.dao.ProductDao;
import jp.co.run.api.dto.product.ProductListDto;
import jp.co.run.api.request.data.ProductSearchRequest;
import jp.co.run.api.response.data.CommonListResponseData;
import jp.co.run.api.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonListResponseData getListProduct(ProductSearchRequest request) throws Exception {

        CommonListResponseData responseData = new CommonListResponseData();
        List<ProductListDto> productListDtos = productDao.getListProduct(request);

        responseData.setOffset(request.getCurrentPage());
        responseData.setTotalCount(productListDtos.size());
        responseData.setResultList(productListDtos);

        return responseData;
    }
}
