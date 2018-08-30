package jp.co.run.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.run.api.request.data.ProductRegistRequest;
import jp.co.run.api.request.data.ProductSearchRequest;
import jp.co.run.api.response.ApiResponse;
import jp.co.run.api.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractController {

    @Autowired
    private ProductService productServie;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ApiResponse regist(@RequestBody ProductRegistRequest request) {

        return createResponse(null);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResponse search(@RequestBody ProductSearchRequest request) throws Exception {

        return createResponse(productServie.getListProduct(request));
    }
}
