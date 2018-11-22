package com.ccff.exception;

public class PasswordLengthException extends Exception {
    //异常信息
    private String message;

    public PasswordLengthException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
