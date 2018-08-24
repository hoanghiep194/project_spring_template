package jp.co.run.api.exception;

import jp.co.run.api.common.DescriptionCode;
import jp.co.run.api.common.ResultType;

public class CheckPasswordFailureException extends ExceptionCustom {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CheckPasswordFailureException(String descriptionSub) {
        super(ResultType.CHECK_PASSWORD.getStatus(), ResultType.CHECK_PASSWORD.getType(),
                DescriptionCode.PASSWORD_ERROR, descriptionSub);
    }

}
