package jp.co.run.api.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.run.api.controller.AbstractController;
import jp.co.run.api.request.data.AccountRegistRequest;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.response.ApiResponse;
import jp.co.run.api.services.AccountService;

/**
 * The Class AccountController.
 */
@RestController
@RequestMapping("/account")
public class AccountController extends AbstractController {

    /** The account service. */
    @Autowired
    private AccountService accountService;

    /**
     * Login.
     *
     * @param request            the request
     * @return the api response
     * @throws Exception the exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResponse login(@RequestBody LoginRequest request) throws Exception {

        return createResponse(accountService.login(request));
    }

    /**
     * Regist.
     *
     * @param request the request
     * @return the api response
     * @throws Exception the exception
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ApiResponse regist(@RequestBody AccountRegistRequest request) throws Exception {

        try {
            accountService.regist(request);
        } catch (Exception e) {
            return createErrorResponse(e);
        }
        
        return createResponse(null);
    }
}
