package jp.co.run.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.run.api.request.data.AccountRegistRequest;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.response.ApiResponse;
import jp.co.run.api.services.AccountService;
import jp.co.run.api.services.SessionInfoService;

/**
 * The Class AccountController.
 */
@RestController
@RequestMapping("/account")
public class AccountController extends AbstractController {

    /** The account service. */
    @Autowired
    private AccountService accountService;

    @Autowired
    private SessionInfoService sessionInfoService;

    private String sessionToken;

    @InitBinder
    public void initBinder(WebDataBinder binder, HttpServletRequest request) throws Exception {

        String endPoint = request.getServletPath();
        if (endPoint.startsWith("/account/login") || endPoint.startsWith("/account/regist")) {
            return;
        }
        // authチェック
        String sessionToken = request.getHeader("Authorization");
        sessionInfoService.authByToken(sessionToken);
        this.sessionToken = sessionToken;
    }

    /**
     * Login.
     *
     * @param request
     *            the request
     * @return the api response
     * @throws Exception
     *             the exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResponse login(@RequestBody LoginRequest request) throws Exception {

        return createResponse(accountService.login(request));
    }

    /**
     * Regist.
     *
     * @param request
     *            the request
     * @return the api response
     * @throws Exception
     *             the exception
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ApiResponse regist(@RequestBody AccountRegistRequest request) throws Exception {

        return createResponse(accountService.regist(request));
    }
}
