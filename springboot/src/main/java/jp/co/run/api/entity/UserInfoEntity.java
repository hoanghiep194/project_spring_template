package jp.co.run.api.entity;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class UserInfoEntity {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "sex")
    private int sex;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone")
    private String phone;

    @Column(name = "regist_user")
    private String registUser;

    @Column(name = "regist_time")
    private Date registTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "delete_flag")
    private int deleteFlag;
}
