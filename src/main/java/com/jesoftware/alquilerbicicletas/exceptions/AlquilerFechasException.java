package com.jesoftware.alquilerbicicletas.exceptions;

import java.time.LocalDate;

public class AlquilerFechasException extends RuntimeException {
    public AlquilerFechasException(LocalDate start, LocalDate end){
        super(String.format("El alquiler debe ser por lo menos por un día: '%s', '%s'", start, end));
    }
}
