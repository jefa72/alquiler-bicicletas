package com.jesoftware.alquilerbicicletas.utils;

import com.jesoftware.alquilerbicicletas.domain.Vehicle;
import com.jesoftware.alquilerbicicletas.resources.VehicleResource;

public class VehicleUtil {

    public static final long id = 1L;
    public static final String marca = "GW";
    public static final String modelo = "100400";
    public static final String imagen = "biciConv01.pgn";
    public static final String estado = "Bueno";
    public static final String clave = "23243";
    public static final double precioAlquiler = 1.5;

    public static VehicleResource buildVehicleResource() {
        VehicleResource vehicleResource;
        return vehicleResource = VehicleResource.builder()
                .vehicleId(id)
                .clave(clave)
                .estadoVehiculo(estado)
                .imagen(imagen)
                .marca(marca)
                .modelo(modelo)
                .precioAlquiler(precioAlquiler)
                .build();
    }

    public static Vehicle buildVehicle() {
        Vehicle vehicle;
        return vehicle = Vehicle.builder()
                .vehicleId(id)
                .clave(clave)
                .estado(estado)
                .imagen(imagen)
                .marca(marca)
                .modelo(modelo)
                .precioAlquiler(precioAlquiler)
                .build();
    }
}