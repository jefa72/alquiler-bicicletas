package com.jesoftware.alquilerbicicletas.controllers;

import com.jesoftware.alquilerbicicletas.exceptions.AlquilerFechasException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FechasAlquilerAdvice {

    @ResponseBody
    @ExceptionHandler(AlquilerFechasException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String fechasAlquilerExceptionHandler(AlquilerFechasException ex) {
        return ex.getMessage();
    }

}