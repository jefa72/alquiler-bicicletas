package com.jesoftware.alquilerbicicletas.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("3")
@EqualsAndHashCode(callSuper = true)
public class Patineta extends Vehicle {
    private Integer autonomia;
    private Float potencia;

    public Patineta(Double precioAlquiler, String marca, String modelo, Integer autonomia, Float potencia) {
        super(precioAlquiler, marca, modelo);
        this.autonomia = autonomia;
        this.potencia = potencia;
    }

}
