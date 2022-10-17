package com.example.springfirstproject.exeptions;

import com.example.springfirstproject.exeptions.entityException.EntityAlreadyExistException;
import com.example.springfirstproject.exeptions.entityException.EntityExceptionHandler;
import com.example.springfirstproject.exeptions.entityException.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.CommunicationException;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.sql.SQLNonTransientException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntityExceptionHandler> handleException(
            EntityAlreadyExistException entityAlreadyExistException){
        EntityExceptionHandler entityExceptionHandler = new EntityExceptionHandler();
        entityExceptionHandler.setInfo(entityAlreadyExistException.getMessage());

        return new ResponseEntity<>(entityExceptionHandler, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler
    public ResponseEntity<RestApplicationError> customerNotFoundHandler(
        EntityNotFoundException entityNotFoundException){

        return new ResponseEntity<>(new RestApplicationError(HttpStatus.NOT_FOUND.value(),
                entityNotFoundException.getMessage())
                ,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<RestApplicationError> fieldValidationHandler(
            ConstraintViolationException constraintViolationException){
        return new ResponseEntity<>(new RestApplicationError(HttpStatus.PRECONDITION_FAILED.value(),
                constraintViolationException.getConstraintViolations()
                        .iterator()
                        .next()
                        .getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            ConstraintViolationException.class,
            CommunicationException.class
    })
    public ResponseEntity<RestApplicationError> SQLExceptionHandler(
            SQLException sqlException){
        return new ResponseEntity<>(new RestApplicationError(HttpStatus.BAD_REQUEST.value(),
                sqlException.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
