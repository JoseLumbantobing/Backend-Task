package com.ideaco.ewallet.response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse {
    private boolean success;
    private String message;
    private String errorCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
