package com.elroi.patientservice.GlobalErrorHandlling;

public class EmailAlreadyExists extends RuntimeException {
    public EmailAlreadyExists(String message) {
        super(message);
    }
}
