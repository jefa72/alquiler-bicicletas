package com.jesoftware.alquilerbicicletas.service;

import com.jesoftware.alquilerbicicletas.domain.Alquiler;
import com.jesoftware.alquilerbicicletas.exceptions.AlquilerFechasException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class ValidacionFechasAlquiler {
    public ValidacionFechasAlquiler() {
    }

    void validarFechasAlquiler(Alquiler alquiler) {
        LocalDate fechaAlquiler = alquiler.getFechaAlquiler();
        LocalDate fechaDevolucion = alquiler.getFechaDevolucion();
        if (Period.between(fechaAlquiler, fechaDevolucion).getDays() < 1) {
            throw new AlquilerFechasException(fechaAlquiler, fechaDevolucion);
        }
    }
}