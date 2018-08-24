package jp.co.run.api.common;

import org.slf4j.helpers.MessageFormatter;

import jp.co.run.api.common.PropertiesFile;

public enum DescriptionCode {

	// 共通系
	SUCCESS("N00-000"),
    PARAMETER_REQUIRED_ERROR("E00-100"),
    PASSWORD_ERROR("E00-114"),
    PARAMETER_ERROR("E00-101"),
    INSERT_DUPLICATE_ERROR("E00-102"),
    UPDATE_NOT_EXISTS_ERROR("E00-103"),
    DATA_DUPLICATE_ERROR("E00-104"),
    APP_VERSION_ERROR("E00-105"),
    CHOICE_ERROR("E00-106"),
    INSERT_ERROR("E00-107"),
    UPDATE_ERROR("E00-108"),
    AUTH_ERROR("E00-109"),
    MAINTENANCE_ERROR("E00-110"),
    SERVER_SYSYTEM_ERROR("E00-111"),
    SERVER_CONNECT_ERROR("E00-112"),
    SELECT_NOT_EXISTS_ERROR("E00-113"),
    SYSTE_ERROR("E00-999");

    private String code;

    private DescriptionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage(Object... messageParams) {
        String message = PropertiesFile.MESSAGE.get(getCode());
        if (messageParams != null && messageParams.length > 0) {
            message = MessageFormatter.arrayFormat(message, messageParams).getMessage();
        }
        return message;
    }
}
