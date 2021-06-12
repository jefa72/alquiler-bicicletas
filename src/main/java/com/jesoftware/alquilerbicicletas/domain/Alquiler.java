package com.jesoftware.alquilerbicicletas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name="rentals")
@Builder
@AllArgsConstructor
public class Alquiler {

    @Id
    @GeneratedValue
    private Long alquiler_Id;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private Double sancion;


    @ManyToOne
    @JoinColumn(name="vehicle_Id", nullable = false)
    @ToString.Exclude
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="user_Id", nullable = false)
    @ToString.Exclude
    private User user;

    @OneToOne
    @JoinColumn(name="pago_Id")
    @ToString.Exclude
    private Pago pago;

    public Alquiler() {
    }

    public Alquiler(LocalDate fechaAlquiler, LocalDate fechaDevolucion, Vehicle vehicle, User user){
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.vehicle = vehicle;
        this.user = user;
    }
}
