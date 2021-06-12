package com.jesoftware.alquilerbicicletas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity(name="vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="vehicle_type",
        discriminatorType = DiscriminatorType.INTEGER)

public class Vehicle {
    @Id
    @GeneratedValue
    protected Long vehicleId;
    protected String estado;
    protected String imagen;
    protected Double precioAlquiler;
    protected String clave;
    @NotNull
    protected String marca;
    @NotNull
    protected String modelo;


    @OneToMany(mappedBy = "vehicle")
    @ToString.Exclude
    protected final List<Alquiler> alquileres = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(Double precioAlquiler, String marca, String modelo){
        this.precioAlquiler = precioAlquiler;
        this.marca = marca;
        this.modelo = modelo;
    }

    public boolean addAlquiler(Alquiler alquiler){
        return alquileres.add(alquiler);
    }

    @Override
    public boolean equals(Object vehicle){
        if (vehicle instanceof Vehicle){
            Vehicle vehicle1 = (Vehicle)vehicle;
            if(this.vehicleId.equals(vehicle1.vehicleId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.vehicleId.intValue();
    }
}
