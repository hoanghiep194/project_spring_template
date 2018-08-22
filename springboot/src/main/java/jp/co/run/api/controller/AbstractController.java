package jp.co.run.api.controller;

import jp.co.run.api.common.ResultType;
import jp.co.run.api.response.ApiResponse;

/**
 * The Class AbstractController.
 */
public class AbstractController {

    /**
     * Creates the response.
     *
     * @param responseData the response data
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
}
