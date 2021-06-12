package com.jesoftware.alquilerbicicletas.repositories;

import com.jesoftware.alquilerbicicletas.domain.*;
import com.jesoftware.alquilerbicicletas.utils.VehicleUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class VehicleRepositoryTest {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlquilerRepository alquilerRepository;

    @Test
    @DisplayName("Find Vehicles By Marca")
    void findByMarcaTest() {
        Vehicle vehicle = VehicleUtil.buildVehicle();
        List<Vehicle> expectedList = new ArrayList<>();
        expectedList.add(vehicle);

        vehicleRepository.save(vehicle);
        List<Vehicle> vehicleList = vehicleRepository.findByMarca(VehicleUtil.marca);
        assertNotNull(vehicleList);
        assertEquals(1, vehicleList.size());
        assertEquals(expectedList, vehicleList);

    }

    @Test
    @DisplayName("Rented Vehicles Query")
    void vehiclesRented() {
        Vehicle vehicle1 = new BiciElectrica(2.0, "Ecotric", "100400", 40.0f, "bomba");
        List<Vehicle> expectedList = new ArrayList<>();
        expectedList.add(vehicle1);
        User user1 = new User("Juan", "abcDE422ds");
        Alquiler alquiler1 = new Alquiler(LocalDate.of(2020, 6, 18),
                LocalDate.of(2020, 6, 19), vehicle1, user1);
        user1.addAlquiler(alquiler1);
        vehicle1.addAlquiler(alquiler1);
        Pago pago1 = new Pago(null, 3.5, "Efectivo", LocalDate.of(2020, 3, 20), 10001, null, alquiler1);

        vehicleRepository.save(vehicle1);
        userRepository.save(user1);
        alquilerRepository.save(alquiler1);

        List<Vehicle> rentedVehicles = vehicleRepository.vehiclesRented(LocalDate.now());
        assertNotNull(rentedVehicles);
        assertEquals(1, rentedVehicles.size());
        assertEquals(expectedList, rentedVehicles);
    }
}