package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, String>> tratarBusinessException(
            BusinessException erro) {

        return ResponseEntity
                .badRequest()
                .body(Map.of("mensagem", erro.getMessage()));
    }
}
