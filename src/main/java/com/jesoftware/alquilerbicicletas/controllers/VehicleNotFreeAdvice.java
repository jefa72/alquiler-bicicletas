package com.jesoftware.alquilerbicicletas.controllers;

import com.jesoftware.alquilerbicicletas.exceptions.VehicleNotFreeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VehicleNotFreeAdvice {

    @ResponseBody
    @ExceptionHandler(VehicleNotFreeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String vehicleNotFreeHandler(VehicleNotFreeException ex) {
        return ex.getMessage();
    }

}