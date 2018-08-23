package jp.co.run.api.exception;

import jp.co.run.api.common.DescriptionCode;

/**
 * The Class ExceptionCustom.
 */
public class ExceptionCustom extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The status. */
    private Integer status;
    
    /** The type. */
    private String type;
    
    /** The description code. */
    private DescriptionCode descriptionCode;
    
    /** The description sub. */
    private String[] descriptionSub;

    /**
     * Instantiates a new exception custom.
     *
     * @param status the status
     * @param type the type
     * @param descriptionCode the description code
     * @param descriptionSub the description sub
     */
    public ExceptionCustom(Integer status, String type, DescriptionCode descriptionCode, String... descriptionSub) {
        this.status = status;
        this.type = type;
        this.descriptionCode = descriptionCode;
        this.descriptionSub = descriptionSub;
    }

    /**
     * Instantiates a new exception custom.
     *
     * @param status the status
     * @param type the type
     * @param descriptionCode the description code
     */
    public ExceptionCustom(Integer status, String type, DescriptionCode descriptionCode) {
        this.status = status;
        this.type = type;
        this.descriptionCode = descriptionCode;
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
    public String[] getDescriptionSub() {
        return descriptionSub;
    }

}
