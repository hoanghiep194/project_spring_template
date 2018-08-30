package jp.co.run.api.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.run.api.common.Constants;
import jp.co.run.api.dao.CommonDao;
import jp.co.run.api.dao.ProductDao;
import jp.co.run.api.dto.product.ProductListDto;
import jp.co.run.api.request.data.ProductSearchRequest;
import jp.co.run.api.util.SqlFileReaderUtil;

@Component
public class ProductDaoImpl implements ProductDao {

    /** The common dao. */
    @Autowired
    private CommonDao commonDao;

    /** The Constant SQL_GET_ACCOUNT. */
    private static final String SQL_SELECT_PRODUCT_BY_USER = "/product/select_product_by_user.sql";

    @Override
    public List<ProductListDto> getListProduct(ProductSearchRequest request) throws Exception {

        // Get content of sql
        String sql = SqlFileReaderUtil.getSql(SQL_SELECT_PRODUCT_BY_USER);
        Map<String, Object> mapParam = new HashMap<String, Object>();
        String sqlQuery = Constants.CONST_STRING_EMPTY;
        String userName = request.getUserName();
        String categoryCode = request.getCategoryCode();
        String categoryName = request.getCategoryName();

        if (userName.isEmpty() && !categoryCode.isEmpty() && !categoryName.isEmpty()) {
            sqlQuery = sql.replace(":condition", "WHERE ca.category_code = :categoryCode AND ca.category_name = :categoryName");
            mapParam.put("categoryCode", request.getCategoryCode());
            mapParam.put("categoryName", request.getCategoryName());
        } if (userName.isEmpty() && categoryCode.isEmpty() && !categoryName.isEmpty()) {
            sqlQuery = sql.replace(":condition", "WHERE ca.category_name = :categoryName");
            mapParam.put("categoryName", request.getCategoryName());
        } else if (userName.isEmpty() && !categoryCode.isEmpty() && categoryName.isEmpty()) {
            sqlQuery = sql.replace(":condition", "WHERE ca.category_code = :categoryCode");
            mapParam.put("categoryCode", request.getCategoryCode());
        } else if (!userName.isEmpty() && categoryCode.isEmpty() && categoryName.isEmpty()) {
            sqlQuery = sql.replace(":condition", "WHERE acc.user_name = :userName");
            mapParam.put("userName", request.getUserName());
        } else if (!userName.isEmpty() && !categoryCode.isEmpty() && categoryName.isEmpty()) {
            sqlQuery = sql.replace(":condition", "WHERE acc.user_name = :userName AND ca.category_code = :categoryCode");
            mapParam.put("userName", request.getUserName());
            mapParam.put("categoryCode", request.getCategoryCode());
        } else if (!userName.isEmpty() && categoryCode.isEmpty() && !categoryName.isEmpty()) {
            sqlQuery = sql.replace(":condition", "WHERE acc.user_name = :userName AND ca.category_name = :categoryName");
            mapParam.put("userName", request.getUserName());
            mapParam.put("categoryName", request.getCategoryName());
        } else if (!userName.isEmpty() && !categoryCode.isEmpty() && !categoryName.isEmpty()) {
            sqlQuery = sql.replace(":condition", "WHERE acc.user_name = :userName AND ca.category_code = :categoryCode AND ca.category_name = :categoryName");
            mapParam.put("userName", request.getUserName());
            mapParam.put("categoryName", request.getCategoryName());
            mapParam.put("categoryCode", request.getCategoryCode());
        } else {
            sqlQuery = sql.replace(":condition", "");
        }

        mapParam.put("offset", request.getCurrentPage());
        mapParam.put("numberRecord", request.getRecordsPerPage());

        List<ProductListDto> productListDtos = commonDao.select(sqlQuery, ProductListDto.class,
                mapParam);

        return productListDtos;
    }

}
