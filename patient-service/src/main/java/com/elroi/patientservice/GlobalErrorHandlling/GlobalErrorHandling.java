package com.elroi.patientservice.GlobalErrorHandlling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalErrorHandling {

    private static final Logger log = LoggerFactory.getLogger(GlobalErrorHandling.class);

    @ExceptionHandler(NotFoundException.class)
    public Map<String, String> notFoundError(NotFoundException ex) {

        Map<String, String> error = new HashMap<>();
        log.warn("NotFoundException: {}", ex.getMessage());
        error.put("message", ex.getMessage());

        return error;
    }
}
