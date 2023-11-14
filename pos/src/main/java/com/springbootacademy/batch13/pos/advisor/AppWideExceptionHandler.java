package com.springbootacademy.batch13.pos.advisor;

import com.springbootacademy.batch13.pos.exception.NotFoundException;
import com.springbootacademy.batch13.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
//controlleradvice + responsebody

public class AppWideExceptionHandler {
    //should mention the
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handlerNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error occuring",e.getMessage()+"azhar"), HttpStatus.NOT_FOUND
        );
    }
}
