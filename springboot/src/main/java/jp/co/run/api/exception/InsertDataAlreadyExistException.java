package jp.co.run.api.exception;

import jp.co.run.api.common.DescriptionCode;
import jp.co.run.api.common.ResultType;

/**
 * The Class InsertDataAlreadyExistException.
 */
public class InsertDataAlreadyExistException extends ExceptionCustom {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new insert data already exist exception.
     *
     * @param descriptionSub the description sub
     */
    public InsertDataAlreadyExistException(String descriptionSub) {
        super(ResultType.INSERT_DATA_ALREADY_EXIST.getStatus(), ResultType.INSERT_DATA_ALREADY_EXIST.getType(),
                DescriptionCode.INSERT_DUPLICATE_ERROR, descriptionSub);
    }

}
