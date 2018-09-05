package jp.co.run.api.dto.session;

import java.util.Date;

import lombok.Data;

@Data
public class SessionInfoDto {
    private String userName;
    private String sessionToken;
    private Date sessionExpired;
}
