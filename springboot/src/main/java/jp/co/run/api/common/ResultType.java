package jp.co.run.api.common;


// TODO: Auto-generated Javadoc
/**
 * The Enum ResultType.
 */
public enum ResultType {

    SUCCESS(200, "success", DescriptionCode.SUCCESS, ""),
    PARAMETERS_SHORTAGE(400, "parameters_shortage", DescriptionCode.PARAMETER_REQUIRED_ERROR, ""),
    PARAMETERS_INVALID(400, "parameters_invalid", DescriptionCode.PARAMETER_ERROR, ""),
    INSERT_DATA_ALREADY_EXIST(400, "insert_data_already_exist", DescriptionCode.INSERT_DUPLICATE_ERROR, ""),
    UPDATE_DATA_NOT_EXIST(400, "updated_data_not_exist", DescriptionCode.UPDATE_NOT_EXISTS_ERROR, ""),
    SELECT_DATA_NOT_EXIST(400, "select_data_not_exist", DescriptionCode.SELECT_NOT_EXISTS_ERROR,""),
    DB_DATA_DUPLICATED(400, "db_data_duplicated", DescriptionCode.DATA_DUPLICATE_ERROR, ""),
    REQUIRED_APP_VERSION_UPDATE(400, "required_app_version_update", DescriptionCode.APP_VERSION_ERROR, ""),
    OPTIONAL_APP_VERSION_UPDATE(200, "optional_app_version_update", DescriptionCode.APP_VERSION_ERROR, ""),
    SELECT_FAILURE(400, "select_failure", DescriptionCode.CHOICE_ERROR, ""),
    INSERT_FAILURE(400, "insert_failure", DescriptionCode.INSERT_ERROR, ""),
    UPDATE_FAILURE(400, "update_failure", DescriptionCode.UPDATE_ERROR, ""),
    DELETE_FAILURE(400, "delete_failure", DescriptionCode.UPDATE_ERROR, ""),
    CHECK_AUTH_INVALID(401, "check_auth_invalid", DescriptionCode.AUTH_ERROR, ""),
    CHECK_TOKEN_EXPIRED(401, "check_token_expired", DescriptionCode.AUTH_ERROR, ""),
    INTERNAL_SERVER_ERROR(500, "internal_server_error", null, "");

    /** The status. */
    private Integer status;

    /** The type. */
    private String type;

    /** The description code. */
    private DescriptionCode descriptionCode;

    /** The description sub. */
    private String descriptionSub;

    /**
     * Instantiates a new result type.
     *
     * @param status the status
     * @param type the type
     * @param descriptionCode the description code
     * @param descriptionSub the description sub
     */
    private ResultType(Integer status, String type, DescriptionCode descriptionCode, String descriptionSub) {
        this.status = status;
        this.type = type;
        this.descriptionCode = descriptionCode;
        this.descriptionSub = descriptionSub;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the description code.
     *
     * @return the description code
     */
    public DescriptionCode getDescriptionCode() {
        return descriptionCode;
    }

    /**
     * Gets the description sub.
     *
     * @return the description sub
     */
    public String getDescriptionSub() {
        return descriptionSub;
    }

}