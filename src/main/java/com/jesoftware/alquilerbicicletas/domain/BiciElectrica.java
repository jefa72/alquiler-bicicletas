package com.jesoftware.alquilerbicicletas.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("2")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BiciElectrica extends Vehicle {
    private Float autonomia;
    private String accesorios;

    public BiciElectrica (Double precioAlquiler, String marca, String modelo, Float autonomia, String accesorios){
        super(precioAlquiler, marca, modelo);
        this.autonomia = autonomia;
        this.accesorios = accesorios;
    }

    @Override
    public String toString(){
        return "[id = " + super.vehicleId + ", " + "marca = " + super.marca + ", " + "modelo = " + super.modelo + ", " +
                "precio alquiler = " + super.precioAlquiler + ", " + "autonomia = " + autonomia + ", " +
                "accesorios = " + accesorios + "]";
    }
}
