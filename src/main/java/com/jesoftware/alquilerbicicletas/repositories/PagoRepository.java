package com.jesoftware.alquilerbicicletas.repositories;

import com.jesoftware.alquilerbicicletas.domain.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    @Query("select sum(p.montoPagado) from Pago p where p.fechaPago >= ?1 and p.fechaPago < ?2")
    Double pagosPorAñoMes(LocalDate startDate, LocalDate endDate);
}
