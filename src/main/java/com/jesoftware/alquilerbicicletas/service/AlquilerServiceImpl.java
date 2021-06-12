package com.jesoftware.alquilerbicicletas.service;

import com.jesoftware.alquilerbicicletas.domain.Alquiler;
import com.jesoftware.alquilerbicicletas.domain.User;
import com.jesoftware.alquilerbicicletas.domain.Vehicle;
import com.jesoftware.alquilerbicicletas.rmappers.AlquilerMapper;
import com.jesoftware.alquilerbicicletas.repositories.AlquilerRepository;
import com.jesoftware.alquilerbicicletas.repositories.UserRepository;
import com.jesoftware.alquilerbicicletas.repositories.VehicleRepository;
import com.jesoftware.alquilerbicicletas.resources.AlquilerResource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlquilerServiceImpl implements AlquilerService {

    private final AlquilerRepository alquilerRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final AlquilerMapper alquilerMapper;
    private final ValidacionFechasAlquiler validacionFechasAlquiler;

    @Override
    public AlquilerResource saveAlquiler(AlquilerResource alquilerResource) {
        Vehicle vehicle = vehicleRepository.getOne(alquilerResource.getVehicleId());
        User user = userRepository.getOne(alquilerResource.getUserId());

        Alquiler alquiler = alquilerMapper.alquilerResourceToAlquiler(alquilerResource, vehicle, user);
        validacionFechasAlquiler.validarFechasAlquiler(alquiler);

        user.addAlquiler(alquiler);
        vehicle.addAlquiler(alquiler);
        Alquiler alquilerResult = alquilerRepository.save(alquiler);
        return alquilerMapper.alquilerToAlquilerResource(alquilerResult, vehicle, user);
    }

}
