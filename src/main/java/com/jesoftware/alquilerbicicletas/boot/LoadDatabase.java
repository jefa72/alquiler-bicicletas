package com.jesoftware.alquilerbicicletas.boot;

import com.jesoftware.alquilerbicicletas.domain.*;
import com.jesoftware.alquilerbicicletas.repositories.AlquilerRepository;
import com.jesoftware.alquilerbicicletas.repositories.PagoRepository;
import com.jesoftware.alquilerbicicletas.repositories.UserRepository;
import com.jesoftware.alquilerbicicletas.repositories.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDataBase(VehicleRepository vehicleRepo, UserRepository userRepo, AlquilerRepository alquilerRepository, PagoRepository pagoRepository) {
        return args -> {
            Vehicle vehicle1 = new BiciConvencional(1.5, "GW", "100400", true, false);
            Vehicle vehicle2 = new BiciConvencional(1.5, "Scott", "100500", true, true);
            Vehicle vehicle3 = new BiciElectrica(2.0, "Ecotric", "100400", 40.0f, "bomba");

            User user1 = new User("Juan", "abcDE422ds");
            User user2 = new User("Pedro", "fdjsREdvs1");

            Alquiler alquiler1 = new Alquiler(LocalDate.of(2020, 6, 9),
                    LocalDate.of(2020, 6, 10), vehicle1, user1);
            user1.addAlquiler(alquiler1);
            vehicle1.addAlquiler(alquiler1);

            Alquiler alquiler2 = new Alquiler(LocalDate.of(2020, 3, 20),
                    LocalDate.of(2020, 3, 21), vehicle2, user1);
            user1.addAlquiler(alquiler2);
            vehicle2.addAlquiler(alquiler2);

            Alquiler alquiler3 = new Alquiler(LocalDate.of(2020, 6, 11),
                    LocalDate.of(2020, 6, 12), vehicle3, user2);
            user1.addAlquiler(alquiler3);
            vehicle2.addAlquiler(alquiler3);

            Pago pago1 = new Pago(null, 3.5, "Efectivo", LocalDate.of(2020, 3, 20), 10001, null, alquiler1);
            Pago pago2 = new Pago(null, 3.5, "Efectivo", LocalDate.of(2020, 3, 23), 10002, null, alquiler3);
            Pago pago3 = new Pago(null, 3.5, "Efectivo", LocalDate.of(2020, 3, 23), 10003, null, alquiler3);



            log.info("Preloading " + vehicleRepo.save(vehicle1));
            log.info("Preloading " + vehicleRepo.save(vehicle2));
            log.info("Preloading " + vehicleRepo.save(vehicle3));

            log.info("Preloading " + userRepo.save(user1));
            log.info("Preloading " + userRepo.save(user2));

            log.info("Preloading " + alquilerRepository.save(alquiler1));
            log.info("Preloading " + alquilerRepository.save(alquiler2));
            log.info("Preloading " + alquilerRepository.save(alquiler3));

            log.info("Preloading" + pagoRepository.save(pago1));
            log.info("Preloading" + pagoRepository.save(pago2));
            log.info("Preloading" + pagoRepository.save(pago3));

            log.info("All vehicles: " + vehicleRepo.findAll());
            log.info("Search vehicles by cambios and suspension (custom query): " + vehicleRepo.findByCambiosAndSuspensionCustomQuery(true, true));
            log.info("Search vehicles by marca: " + vehicleRepo.findByMarca("GW"));
            log.info("Search vehicles by marca (custom query): " + vehicleRepo.findByMarcaCustomQuery("GW"));
            log.info("Vehiculos alquilados (custom query): " + vehicleRepo.vehiclesRented(LocalDate.now()));
            log.info("Ingresos alquileres por rango fechas: $" + pagoRepository.pagosPorAñoMes(
                    LocalDate.of(2020, 3, 1), LocalDate.of(2020, 4, 1)));
        };

    }

}
