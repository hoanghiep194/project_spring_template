package jp.co.run.api.exception;

import jp.co.run.api.common.DescriptionCode;
import jp.co.run.api.common.ResultType;

/**
 * リクエストパラメータがバリデーションを通らない時
 */
public class ParametersInvalidException extends ExceptionCustom {

	private static final long serialVersionUID = 1L;

	public ParametersInvalidException(String descriptionSub) {
		super(ResultType.PARAMETERS_INVALID.getStatus(), ResultType.PARAMETERS_INVALID.getType(),
				DescriptionCode.PARAMETER_ERROR, descriptionSub);
    }
}
