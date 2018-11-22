package com.ccff.model;

import com.ccff.validator.UserValidationGroup1;
import com.ccff.validator.UserValidationGroup2;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    private int userId;
    //@NotEmpty(message = "{user.username.isEmpty}", groups = {UserValidationGroup1.class})
    private String username;
    //@Size(min = 6, max = 12, message = "{user.password.length.error}", groups = {UserValidationGroup2.class})
    private String password;
    private Date loginDate;

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
