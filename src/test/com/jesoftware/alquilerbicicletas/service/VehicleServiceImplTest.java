package com.jesoftware.alquilerbicicletas.service;

import com.jesoftware.alquilerbicicletas.domain.Vehicle;
import com.jesoftware.alquilerbicicletas.exceptions.VehicleNotFoundException;
import com.jesoftware.alquilerbicicletas.rmappers.VehicleMapper;
import com.jesoftware.alquilerbicicletas.repositories.VehicleRepository;
import com.jesoftware.alquilerbicicletas.resources.VehicleResource;
import com.jesoftware.alquilerbicicletas.utils.VehicleUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private VehicleMapper vehicleMapper;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    void saveVehicleTest() {
        VehicleResource vehicleResource = VehicleUtil.buildVehicleResource();
        Vehicle vehicle = VehicleUtil.buildVehicle();
        when(vehicleRepository.save(any())).thenReturn(vehicle);
        when(vehicleMapper.vehicleResourceToVehicle(any())).thenReturn(vehicle);
        when(vehicleMapper.vehicleToVehicleResource(any())).thenReturn(vehicleResource);

        VehicleResource vehicleResource1 = vehicleService.saveVehicle(vehicleResource);

        assertNotNull(vehicleResource1);
        assertEquals(vehicleResource.getVehicleId(), vehicleResource1.getVehicleId());
    }

    @Test
    void getExistentVehicle() {
        VehicleResource vehicleResource = VehicleUtil.buildVehicleResource();
        Optional<Vehicle> optionalVehicle = Optional.of(VehicleUtil.buildVehicle());
        when(vehicleRepository.findById(anyLong())).thenReturn(optionalVehicle);
        when(vehicleMapper.vehicleToVehicleResource(any())).thenReturn(vehicleResource);

        VehicleResource vehicleResource1 = vehicleService.getVehicle(vehicleResource.getVehicleId());

        assertNotNull(vehicleResource1);
        assertEquals(vehicleResource.getVehicleId(), vehicleResource1.getVehicleId());
    }

    @Test
    void getNoExistentVehicle() {
        VehicleResource vehicleResource = VehicleUtil.buildVehicleResource();
        Optional<Vehicle> optionalVehicle = Optional.empty();
        when(vehicleRepository.findById(anyLong())).thenReturn(optionalVehicle);

        VehicleNotFoundException vehicleNotFoundException = assertThrows(VehicleNotFoundException.class, ()->vehicleService.getVehicle(vehicleResource.getVehicleId()));
        assertEquals(vehicleNotFoundException.getMessage(), String.format("Could not find vehicle with id '%d'", vehicleResource.getVehicleId()));

    }
}