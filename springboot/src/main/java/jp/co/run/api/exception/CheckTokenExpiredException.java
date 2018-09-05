package jp.co.run.api.exception;

import jp.co.run.api.common.DescriptionCode;
import jp.co.run.api.common.ResultType;

/**
 * IDトークンの有効期限が切れた時（例: 90日後）
 */
public class CheckTokenExpiredException extends ExceptionCustom {

	private static final long serialVersionUID = 1L;

	public CheckTokenExpiredException(String descriptionSub) {
		super(ResultType.CHECK_TOKEN_EXPIRED.getStatus(), ResultType.CHECK_TOKEN_EXPIRED.getType(),
				DescriptionCode.AUTH_ERROR, descriptionSub);
    }
}
