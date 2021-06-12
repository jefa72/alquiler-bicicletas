package com.jesoftware.alquilerbicicletas.repositories;

import com.jesoftware.alquilerbicicletas.domain.Alquiler;
import com.jesoftware.alquilerbicicletas.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
}
