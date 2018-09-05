package jp.co.run.api.exception;

import jp.co.run.api.common.DescriptionCode;
import jp.co.run.api.common.ResultType;

/**
 * 認証に失敗した時
 */
public class CheckAuthInvalidException extends ExceptionCustom {

	private static final long serialVersionUID = 1L;

	public CheckAuthInvalidException(String descriptionSub) {
		super(ResultType.CHECK_AUTH_INVALID.getStatus(), ResultType.CHECK_AUTH_INVALID.getType(),
				DescriptionCode.AUTH_ERROR, descriptionSub);
    }
}
