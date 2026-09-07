package com.elroi.patientservice.status;

import lombok.Getter;

@Getter
public enum LoginStatus {

    SUCCESS("SUCCESS"),
    FAILED("FAILED");

    private final String status;

    LoginStatus(String status) {
        this.status = status;
    }
}