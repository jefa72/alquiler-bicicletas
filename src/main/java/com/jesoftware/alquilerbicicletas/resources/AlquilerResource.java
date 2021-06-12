package com.jesoftware.alquilerbicicletas.resources;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlquilerResource {

    private Long alquiler_Id;
    @NotBlank
    private String fechaAlquilerStr;
    @NotBlank
    private String fechaDevolucionStr;
    private Double sancion;
    @NotNull
    private Long vehicleId;
    @NotNull
    private Long userId;
    private PagoResource pagoResource;

}
