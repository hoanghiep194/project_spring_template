package jp.co.run.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="tbl_user")
@Entity
public class AccountEntity {

    @Id
    private long id;
    @Column(name="user_name")
    private String userName;
    @Column(name="pass_word")
    private String password;
}
