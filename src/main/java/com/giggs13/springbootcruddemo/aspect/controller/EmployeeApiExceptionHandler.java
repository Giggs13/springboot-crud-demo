package com.giggs13.springbootcruddemo.aspect.controller;

import com.giggs13.springbootcruddemo.controller.EmployeeApiController;
import com.giggs13.springbootcruddemo.entity.error.EmployeeErrorResponse;
import com.giggs13.springbootcruddemo.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = {
        EmployeeApiController.class
})
public class EmployeeApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(ResourceNotFoundException ex) {
        EmployeeErrorResponse response = new EmployeeErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception ex) {
        EmployeeErrorResponse response = new EmployeeErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
