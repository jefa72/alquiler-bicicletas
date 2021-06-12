package com.jesoftware.alquilerbicicletas.service;

import com.jesoftware.alquilerbicicletas.domain.User;
import com.jesoftware.alquilerbicicletas.domain.Vehicle;
import com.jesoftware.alquilerbicicletas.exceptions.VehicleNotFoundException;
import com.jesoftware.alquilerbicicletas.repositories.UserRepository;
import com.jesoftware.alquilerbicicletas.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

}
