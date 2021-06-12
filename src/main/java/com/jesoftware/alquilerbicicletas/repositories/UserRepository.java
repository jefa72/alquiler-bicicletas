package com.jesoftware.alquilerbicicletas.repositories;

import com.jesoftware.alquilerbicicletas.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
