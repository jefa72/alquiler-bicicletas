package com.jesoftware.alquilerbicicletas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    @Id
    @GeneratedValue
    private Long pago_Id;
    private Double montoPagado;
    private String medioPago;
    private LocalDate fechaPago;
    private Integer referenciaPago;
    private String entidadBancaria;

    @OneToOne(mappedBy = "pago")
    @ToString.Exclude
    private Alquiler alquiler;

    /*public Pago(Double montoPagado, String medioPago, LocalDate fechaPago, String referenciaPago, String enditadBancaria){
        this.montoPagado = montoPagado;
        this.medioPago = medioPago;
        this.fechaPago = fechaPago;
        this.referenciaPago = referenciaPago;
        this.entidadBancaria = enditadBancaria;
    }*/
}
