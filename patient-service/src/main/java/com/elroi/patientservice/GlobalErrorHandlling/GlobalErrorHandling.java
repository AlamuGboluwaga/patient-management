package com.elroi.patientservice.GlobalErrorHandlling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalErrorHandling {

    private static final Logger log = LoggerFactory.getLogger(GlobalErrorHandling.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(NotFoundException.class)
    public Map<String, String> notFoundError(NotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        log.warn("NotFoundException: {}", ex.getMessage());
        error.put("message", ex.getMessage());
        return error;
    }

    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<Map<String, String>> emailAlreadyExists(EmailAlreadyExists ex) {
        Map<String, String> error = new HashMap<>();
        log.warn("EmailAlreadyExist: {}", ex.getMessage());
        error.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, String> error = new HashMap<>();
        log.warn("DataIntegrityViolationException: {}", ex.getMessage());
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
