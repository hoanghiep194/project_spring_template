package jp.co.run.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Instantiates a new account entity.
 */
@Data
@Entity
@Table(name = "account")
public class AccountEntity {

    /** The id. */
    @Id
    private int id;

    /** The user name. */
    @Column(name = "user_name")
    private String userName;

    /** The expiry date. */
    @Column(name = "expiry_date")
    private Date expiryDate;

    /** The delete expired account. */
    @Column(name = "delete_expired_account")
    private Date deleteExpiredAccount;

    /** The mail address. */
    @Column(name = "mail_address")
    private String mailAddress;

    /** The role id. */
    @Column(name = "role_id")
    private int roleId;

    /** The register user. */
    @Column(name = "register_user")
    private String registerUser;

    /** The register time. */
    @Column(name = "register_time")
    private Date registerTime;

    /** The update user. */
    @Column(name = "update_user")
    private String updateUser;

    /** The update time. */
    @Column(name = "update_time")
    private Date updateTime;

    /** The delete flag. */
    @Column(name = "delete_flag")
    private int deleteFlag;
}
