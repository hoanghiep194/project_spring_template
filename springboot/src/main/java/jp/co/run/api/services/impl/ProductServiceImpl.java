package jp.co.run.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.run.api.dao.AccountDao;
import jp.co.run.api.dao.ProductDao;
import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.dto.account.UserInfoDto;
import jp.co.run.api.dto.product.ProductDto;
import jp.co.run.api.request.data.ProductSearchRequest;
import jp.co.run.api.response.data.CommonListResponseData;
import jp.co.run.api.response.data.ProductListResponseData;
import jp.co.run.api.response.data.ProductResponseData;
import jp.co.run.api.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonListResponseData getListProduct(ProductSearchRequest request) throws Exception {

        CommonListResponseData responseData = new CommonListResponseData();

        // Get all account
        List<AccountDto> accountListDto = accountDao.getListAccount();

        List<ProductListResponseData> productResponseData = new ArrayList<ProductListResponseData>();

        for(AccountDto accountDto : accountListDto) {
            ProductListResponseData response = new ProductListResponseData();
            // Get userinfo from account
            UserInfoDto dto = accountDao.getDetailUserInfo(accountDto.getUserName());
            BeanUtils.copyProperties(dto, response);

            // Get product of account
            List<ProductDto> productListDto =  productDao.getListProduct(request,dto.getUserName());
            List<ProductResponseData> productList = new ArrayList<ProductResponseData>();

            for(ProductDto productDto : productListDto) {
                ProductResponseData productResponse = new ProductResponseData();
                BeanUtils.copyProperties(productDto, productResponse);
                productList.add(productResponse);
            }
            response.setProductList(productList);
            productResponseData.add(response);
        }

        responseData.setOffset(request.getCurrentPage());
        responseData.setTotalCount(productResponseData.size());
        responseData.setResultList(productResponseData);

        return responseData;
    }
}
