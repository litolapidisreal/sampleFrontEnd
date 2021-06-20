package com.example.sampleFrontEnd.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class APIResponse {

    private String message;
    private String status;


    public APIResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

