package com.jesoftware.alquilerbicicletas.service;

import com.jesoftware.alquilerbicicletas.domain.Alquiler;
import com.jesoftware.alquilerbicicletas.exceptions.AlquilerFechasException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ValidacionFechasAlquilerTest {

    private ValidacionFechasAlquiler validacionFechasAlquiler;

    @BeforeEach
    void initService() {
        validacionFechasAlquiler = new ValidacionFechasAlquiler();
    }

    @Test
    void validarFechasAlquiler() {
        Alquiler alquiler = Alquiler.builder()
                .fechaAlquiler(LocalDate.of(2020,6,18))
                .fechaDevolucion(LocalDate.of(2020,6,18))
                .build();

        Exception exception = assertThrows(AlquilerFechasException.class, () -> {
            validacionFechasAlquiler.validarFechasAlquiler(alquiler);
        });

        String expectedMessage = "El alquiler debe ser por lo menos por un día";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }
}