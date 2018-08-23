package jp.co.run.api.controller;

import jp.co.run.api.common.DescriptionCode;
import jp.co.run.api.common.ResultType;
import jp.co.run.api.exception.ExceptionCustom;
import jp.co.run.api.response.ApiResponse;

/**
 * The Class AbstractController.
 */
public class AbstractController {

    /**
     * Creates the response.
     *
     * @param responseData
     *            the response data
     * @return the api response
     */
    protected ApiResponse createResponse(Object responseData) {

        ApiResponse response = new ApiResponse();
        response.setStatus(ResultType.SUCCESS.getStatus());
        response.setType(ResultType.SUCCESS.getType());
        response.setDescription(ResultType.SUCCESS.getDescriptionCode().getMessage());
        response.setDescriptionSub(ResultType.SUCCESS.getDescriptionSub());
        response.setResultData(responseData);
        return response;
    }

    /**
     * Creates the error response.
     *
     * @param e the e
     * @return the api response
     */
    protected ApiResponse createErrorResponse(Exception e) {

        Integer status = null;
        String type = null;
        DescriptionCode descriptionCode = null;
        String descriptionSub = null;

        if (e instanceof ExceptionCustom) {
            status = ((ExceptionCustom) e).getStatus();
            type = ((ExceptionCustom) e).getType();
            descriptionCode = ((ExceptionCustom) e).getDescriptionCode();
            descriptionSub = null;
            if (((ExceptionCustom) e).getDescriptionSub() != null
                    && ((ExceptionCustom) e).getDescriptionSub().length > 0) {
                descriptionSub = ((ExceptionCustom) e).getDescriptionSub()[0];
            }
            ;
        } else {
            status = ResultType.INTERNAL_SERVER_ERROR.getStatus();
            type = ResultType.INTERNAL_SERVER_ERROR.getType();
            descriptionCode = ResultType.INTERNAL_SERVER_ERROR.getDescriptionCode();
            descriptionSub = ResultType.INTERNAL_SERVER_ERROR.getDescriptionSub();
        }

        ApiResponse response = new ApiResponse();
        response.setStatus(status);
        response.setDescription(descriptionCode.getMessage());
        response.setDescriptionSub(descriptionSub);
        response.setType(type);
        response.setResultData(null);
        return response;
    }
}
