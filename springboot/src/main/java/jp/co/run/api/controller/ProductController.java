package jp.co.run.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.run.api.request.data.ProductRegistRequest;
import jp.co.run.api.request.data.ProductSearchRequest;
import jp.co.run.api.response.ApiResponse;
import jp.co.run.api.services.ProductService;
import jp.co.run.api.services.SessionInfoService;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractController {

    @Autowired
    private ProductService productServie;

    @Autowired
    private SessionInfoService sessionInfoService;

    private String sessionToken;

    @InitBinder
    public void initBinder(WebDataBinder binder, HttpServletRequest request) throws Exception {

        // authチェック
        String sessionToken = request.getHeader("Authorization");
        sessionInfoService.authByToken(sessionToken);
        this.sessionToken = sessionToken;
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ApiResponse regist(@RequestBody ProductRegistRequest request) {

        return createResponse(null);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResponse search(@RequestBody ProductSearchRequest request) throws Exception {

        return createResponse(productServie.getListProduct(request));
    }
}
