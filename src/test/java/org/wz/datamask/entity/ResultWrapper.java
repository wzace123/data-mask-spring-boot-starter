package org.wz.datamask.entity;

import java.io.Serializable;

public class ResultWrapper<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    private boolean sucess;

    public ResultWrapper(int code, String message, T data, boolean sucess) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.sucess = sucess;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    @Override
    public String toString() {
        return "ResultWapper{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", sucess=" + sucess +
                '}';
    }
}
