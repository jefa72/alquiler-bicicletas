package com.jesoftware.alquilerbicicletas.resources;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResource {
    private Long vehicleId;
    private String estadoVehiculo;
    private String imagen;
    private Double precioAlquiler;
    private String clave;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
}
