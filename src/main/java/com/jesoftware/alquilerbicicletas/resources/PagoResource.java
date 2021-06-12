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
public class PagoResource {
    private Long pago_Id;
    @NotBlank
    private Double montoPagado;
    @NotBlank
    private String medioPago;
    @NotBlank
    private String fechaPago;
    private Integer referenciaPago;
    private String entidadBancaria;
}
