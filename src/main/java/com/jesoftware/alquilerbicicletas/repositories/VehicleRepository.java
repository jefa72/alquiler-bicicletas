package com.jesoftware.alquilerbicicletas.repositories;

import com.jesoftware.alquilerbicicletas.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByMarca(String marca);

    @Query("select v from vehicles v where v.marca = ?1")
    List<Vehicle> findByMarcaCustomQuery(String marca);

    @Query("select v from vehicles v where v.cambios = ?1 and v.suspension = ?2")
    List<Vehicle> findByCambiosAndSuspensionCustomQuery(Boolean cambios, Boolean suspension);

    @Query("select v, r from vehicles v LEFT JOIN v.alquileres r WHERE r.fechaAlquiler < ?1 AND r.fechaDevolucion >= ?1 ")
    List<Vehicle> vehiclesRented(LocalDate localDate);

}
