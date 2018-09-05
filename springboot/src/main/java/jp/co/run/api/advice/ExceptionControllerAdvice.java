package jp.co.run.api.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.run.api.common.DescriptionCode;
import jp.co.run.api.common.LoggerUtils;
import jp.co.run.api.common.ResultType;
import jp.co.run.api.exception.ExceptionCustom;
import jp.co.run.api.exception.ParametersInvalidException;
import jp.co.run.api.response.ApiResponse;

/**
 * The Class ExceptionControllerAdvice.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * Inits the binder.
     *
     * @param binder
     *            the binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {

    }

    /**
     * Exception.
     *
     * @param e
     *            the e
     * @return the api response
     * @throws ParametersInvalidException
     *             the parameters invalid exception
     */
    @ExceptionHandler(TypeMismatchException.class)
    public @ResponseBody ApiResponse exception(TypeMismatchException e) throws ParametersInvalidException {

        ParametersInvalidException pe = new ParametersInvalidException("");
        return makeResponse(pe.getStatus(), pe.getType(), pe.getDescriptionCode().getMessage());
    }

    /**
     * Exception.
     *
     * @param e
     *            the e
     * @return the api response
     */
    @ExceptionHandler(ExceptionCustom.class)
    public @ResponseBody ApiResponse exception(ExceptionCustom e) {

        LoggerUtils.logError(this, e);
        Integer status = e.getStatus();
        String type = e.getType();
        String description = e.getDescriptionCode().getMessage(e.getDescriptionSub());
        String descriptionSub = null;
        if (e.getDescriptionSub() != null && e.getDescriptionSub().length > 0) {
            descriptionSub = e.getDescriptionSub()[0];
        }
        return makeResponse(status, type, description, descriptionSub);
    }

    /**
     * Exception.
     *
     * @param e
     *            the e
     * @return the api response
     */
    @ExceptionHandler(Exception.class)
    public @ResponseBody ApiResponse exception(Exception e) {

        LoggerUtils.logError(this, e);
        Integer status = ResultType.INTERNAL_SERVER_ERROR.getStatus();
        String type = ResultType.INTERNAL_SERVER_ERROR.getType();
        String description = DescriptionCode.SYSTE_ERROR.getMessage();
        return makeResponse(status, type, description);
    }

    /**
     * Make response.
     *
     * @param status
     *            the status
     * @param type
     *            the type
     * @param description
     *            the description
     * @return the api response
     */
    private ApiResponse makeResponse(Integer status, String type, String description) {

        ApiResponse response = new ApiResponse();
        response.setStatus(status);
        response.setType(type);
        response.setDescription(description);
        return response;
    }

    /**
     * Make response.
     *
     * @param status
     *            the status
     * @param type
     *            the type
     * @param description
     *            the description
     * @param descriptionSub
     *            the description sub
     * @return the api response
     */
    private ApiResponse makeResponse(Integer status, String type, String description, String descriptionSub) {

        ApiResponse response = makeResponse(status, type, description);
        response.setDescriptionSub(descriptionSub);
        return response;
    }

    /**
     * Model attribute.
     */
    @ModelAttribute
    public void modelAttribute() {

    }
}
