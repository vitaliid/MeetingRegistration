package com.sdarm.meetingregistration.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.security.AccessControlException;

@RequiredArgsConstructor
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final ExceptionHandlerService exceptionHandlerService;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> unknownExceptionHandler(Exception exception, HttpServletRequest request) {
        return exceptionHandlerService.unknownExceptionHandler(exception, request);
    }

    @ExceptionHandler(value = AccessControlException.class)
    public ResponseEntity<Object> accessExceptionHandler(Exception exception, HttpServletRequest request) {
        return exceptionHandlerService.unknownExceptionHandler(exception, request, HttpStatus.UNAUTHORIZED);
    }
}
