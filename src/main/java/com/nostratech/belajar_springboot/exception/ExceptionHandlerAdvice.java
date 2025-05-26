package com.nostratech.belajar_springboot.exception;

import com.nostratech.belajar_springboot.dto.ErrorMessageDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorMessageDTO errorMessage = new ErrorMessageDTO(status.value(), ex.getBindingResult().getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
