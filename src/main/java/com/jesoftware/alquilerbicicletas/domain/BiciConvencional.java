package com.jesoftware.alquilerbicicletas.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("1")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BiciConvencional extends Vehicle {
    private Boolean cambios;
    private Boolean suspension;

    public BiciConvencional(Double precioAlquiler, String marca, String modelo, Boolean cambios, Boolean suspension){
        super(precioAlquiler, marca, modelo);
        this.cambios = cambios;
        this.suspension = suspension;
    }

    @Override
    public String toString(){
        return "[id = " + super.vehicleId + ", " + "marca = " + super.marca + ", " + "modelo = " + super.modelo + ", " +
                "precio alquiler = " + getPrecioAlquiler() + ", " + "cambios = " + cambios + ", " +
                "suspension = " + suspension + "]";
    }
}
