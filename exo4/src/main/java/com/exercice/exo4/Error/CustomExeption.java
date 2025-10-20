package com.exercice.exo4.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class CustomExeption {

    @ExceptionHandler(PersonNotFoundExeption.class)
    public ResponseEntity<Error> handlePersonNotFoundExeption(PersonNotFoundExeption notFound){
        Error error = new Error();
        error.setMessage(notFound.getMessage());
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception exception){
        Error error = new Error();
        error.setMessage(exception.getMessage());
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersonNotValidExeption.class)
    public ResponseEntity<Error> handlePersonNotValidExeption(PersonNotValidExeption e){
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setCode(HttpStatus.NOT_ACCEPTABLE.value());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(BindException.class)
    public  ResponseEntity<List<FieldError>> hanleBind(BindException e){
        List<FieldError> list = e.getFieldErrors().stream().map(
                fe -> new FieldError(e.getObjectName(), fe.getField(),fe.getDefaultMessage(), fe.getCode())
        ).toList();
        return ResponseEntity.badRequest().body(list);
    }
}
