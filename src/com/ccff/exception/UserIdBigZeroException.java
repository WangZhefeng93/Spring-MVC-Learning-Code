package com.ccff.exception;

import java.io.IOException;

public class UserIdBigZeroException extends Exception {
    //异常信息
    private String message;

    public UserIdBigZeroException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        try {
            return new ExceptionPropertiesUtil().getExceptionMsg(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
