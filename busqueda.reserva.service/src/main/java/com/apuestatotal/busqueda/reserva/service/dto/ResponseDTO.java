package com.apuestatotal.busqueda.reserva.service.dto;

import java.util.List;

public class ResponseDTO {
    private String code;
    private String message;
    private List<RutaDTO> data;

    public ResponseDTO() {
    }

    public ResponseDTO(String code, String message, List<RutaDTO> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<RutaDTO> getData() {
        return data;
    }
    public void setData(List<RutaDTO> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDTO [code=" + code + ", data=" + data + ", message=" + message + "]";
    }
    
}
