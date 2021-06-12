package com.jesoftware.alquilerbicicletas.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(Long id){
        super(String.format("Could not find vehicle with id '%d'", id));
    }
}
