package com.sh.crm.classes.exception;

/**
 * Created by Administrator on 2016/12/26.
 * 自定义异常类
 */
public class CustomException extends Exception {

    private String message;//异常信息

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
