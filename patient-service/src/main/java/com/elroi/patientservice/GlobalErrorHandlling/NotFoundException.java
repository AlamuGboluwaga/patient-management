package com.elroi.patientservice.GlobalErrorHandlling;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {

        super(message);
    }
}
