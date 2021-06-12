package com.jesoftware.alquilerbicicletas.service;

import com.jesoftware.alquilerbicicletas.rmappers.VehicleMapper;
import com.jesoftware.alquilerbicicletas.repositories.VehicleRepository;
import com.jesoftware.alquilerbicicletas.resources.VehicleResource;
import com.jesoftware.alquilerbicicletas.utils.VehicleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class VehicleServiceImpl2Test {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleMapper vehicleMapper;

    private VehicleServiceImpl2 vehicleServiceImpl2;

    @BeforeEach
    void setUp() {
        vehicleServiceImpl2 = new VehicleServiceImpl2(vehicleRepository, vehicleMapper);
    }

    @Test
    void saveVehicle() {
        VehicleResource vehicleResource = VehicleUtil.buildVehicleResource();

        VehicleResource vehicleResource1 = vehicleServiceImpl2.saveVehicle(vehicleResource);

        assertNotNull(vehicleResource1);
        assertEquals(vehicleResource.getVehicleId(), vehicleResource1.getVehicleId());
    }
}