package com.jesoftware.alquilerbicicletas.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super(String.format("Could not find user with id '%d'", id));
    }
}
