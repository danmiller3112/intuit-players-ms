package com.intuit.service.players.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(PlayerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionResponse resourceNotFound(final PlayerNotFoundException ex) {
        return new ExceptionResponse("Player Not Found", ex.getMessage());
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ExceptionResponse allExceptions(final Exception ex) {
//        return new ExceptionResponse("Bad Request", "Something weird happened: " + ex.getMessage());
//
//    }

}
