package com.jesoftware.alquilerbicicletas.utils;

import com.jesoftware.alquilerbicicletas.resources.AlquilerResource;
import com.jesoftware.alquilerbicicletas.resources.PagoResource;

public class AlquilerUtil {

    public static final long alquiler_Id = 5L;
    public static final long pago_Id = 5L;
    public static final long vehicle_Id = 3L;
    public static final long user_Id = 2L;
    public static final double precioAlquiler = 1.5;
    public static final double sancion = 1.5f;
    public static final String fechaAlquiler = "18-06-2020";
    public static final String emptyString = "";
    public static final String fechaDevolucion = "19-06-2020";
    public static final String medioPagoEfectivo = "efectivo";

    public static AlquilerResource buildAlquilerResource() {

        PagoResource pagoResource = buildPagoReource();
        AlquilerResource alquilerResource;
        return alquilerResource = AlquilerResource.builder()
                .alquiler_Id(alquiler_Id)
                .fechaAlquilerStr(fechaAlquiler)
                .fechaDevolucionStr(fechaDevolucion)
                .sancion(sancion)
                .userId(user_Id)
                .vehicleId(vehicle_Id)
                .pagoResource(pagoResource)
                .build();
    }

    public static AlquilerResource buildIvalidAlquilerResource() {

        PagoResource pagoResource = buildPagoReource();
        AlquilerResource alquilerResource;
        return alquilerResource = AlquilerResource.builder()
                .alquiler_Id(alquiler_Id)
                .fechaAlquilerStr(emptyString)
                .fechaDevolucionStr(fechaDevolucion)
                .sancion(sancion)
                .userId(user_Id)
                .vehicleId(vehicle_Id)
                .pagoResource(pagoResource)
                .build();
    }

    public static AlquilerResource buildIvalidAlquilerResourceWithWrongDates() {

        PagoResource pagoResource = buildPagoReource();
        AlquilerResource alquilerResource;
        return alquilerResource = AlquilerResource.builder()
                .alquiler_Id(alquiler_Id)
                .fechaAlquilerStr(fechaDevolucion)
                .fechaDevolucionStr(fechaDevolucion)
                .sancion(sancion)
                .userId(user_Id)
                .vehicleId(vehicle_Id)
                .pagoResource(pagoResource)
                .build();
    }

    public static PagoResource buildPagoReource(){
        PagoResource pagoResource = PagoResource.builder()
                .pago_Id(pago_Id)
                .fechaPago(fechaAlquiler)
                .medioPago(medioPagoEfectivo)
                .montoPagado(precioAlquiler)
                .build();
        return pagoResource;
    }
}