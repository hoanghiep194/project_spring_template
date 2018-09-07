package jp.co.run.api.exception;

import jp.co.run.api.common.DescriptionCode;
import jp.co.run.api.common.ResultType;

/**
 * DBへの更新が失敗した時
 */
public class UpdateFailureException extends ExceptionCustom {

	private static final long serialVersionUID = 1L;

	public UpdateFailureException(String descriptionSub) {
		super(ResultType.UPDATE_FAILURE.getStatus(), ResultType.UPDATE_FAILURE.getType(),
				DescriptionCode.UPDATE_ERROR, descriptionSub);
    }
}
