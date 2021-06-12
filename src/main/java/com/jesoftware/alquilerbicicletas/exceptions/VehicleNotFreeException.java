package com.jesoftware.alquilerbicicletas.exceptions;

public class VehicleNotFreeException extends RuntimeException {
    public VehicleNotFreeException(Long id){
        super("Vehicle with id " + id + " is not free!");
    }
}
