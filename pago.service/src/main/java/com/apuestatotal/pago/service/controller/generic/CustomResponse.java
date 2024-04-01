package com.apuestatotal.pago.service.controller.generic;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse {
    private CodeEnum code;
    private Object message;
    private Object data;
    private String path;

    public CustomResponse() {
    }

    public CustomResponse(CodeEnum code, Object message, Object data, String path) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.path = path;
    }

    public CodeEnum getCode() {
        return code;
    }

    public void setCode(CodeEnum code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "CustomResponse{" +
                "code=" + code +
                ", message=" + message +
                ", data=" + data +
                ", path='" + path + '\'' +
                '}';
    }
}
