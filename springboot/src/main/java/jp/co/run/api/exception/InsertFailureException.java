package jp.co.run.api.exception;

import jp.co.run.api.common.DescriptionCode;
import jp.co.run.api.common.ResultType;

/**
 * The Class InsertFailureException.
 */
public class InsertFailureException extends ExceptionCustom {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new insert failure exception.
     *
     * @param descriptionSub the description sub
     */
    public InsertFailureException(String descriptionSub) {
        super(ResultType.INSERT_FAILURE.getStatus(), ResultType.INSERT_FAILURE.getType(), DescriptionCode.INSERT_ERROR,
                descriptionSub);
    }

}
