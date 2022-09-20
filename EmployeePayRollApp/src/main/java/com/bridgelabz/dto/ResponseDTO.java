package com.bridgelabz.dto;

import lombok.Data;
@Data
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
     @Override
    public String toString() {
        return "ResponseDTO{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}