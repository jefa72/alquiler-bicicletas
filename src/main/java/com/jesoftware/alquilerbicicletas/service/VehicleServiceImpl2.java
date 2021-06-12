package com.jesoftware.alquilerbicicletas.service;

import com.jesoftware.alquilerbicicletas.domain.Vehicle;
import com.jesoftware.alquilerbicicletas.exceptions.VehicleNotFoundException;
import com.jesoftware.alquilerbicicletas.rmappers.VehicleMapper;
import com.jesoftware.alquilerbicicletas.repositories.VehicleRepository;
import com.jesoftware.alquilerbicicletas.resources.VehicleResource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class VehicleServiceImpl2 implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public VehicleResource saveVehicle(VehicleResource vehicleResource) {
        Vehicle vehicle = vehicleMapper.vehicleResourceToVehicle(vehicleResource);
        return vehicleMapper.vehicleToVehicleResource(vehicleRepository.save(vehicle));
    }

    @Override
    public List<VehicleResource> getVehicles() {
        return vehicleMapper.vehicleToVehicleResourceList(vehicleRepository.findAll());
    }

    @Override
    public List<VehicleResource> getRentedVehicles(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return vehicleMapper.vehicleToVehicleResourceList(vehicleRepository.vehiclesRented(date));
    }

    @Override
    public List<VehicleResource> getFreeVehicles(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        List<VehicleResource> rentedVehicles = vehicleMapper.vehicleToVehicleResourceList(vehicleRepository.vehiclesRented(date));
        List<VehicleResource> allVehicles = vehicleMapper.vehicleToVehicleResourceList(vehicleRepository.findAll());
        allVehicles.removeAll(rentedVehicles);
        return allVehicles;
    }

    @Override
    public VehicleResource getVehicle(Long id) {
        return vehicleMapper.vehicleToVehicleResource(vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(id)));
    }

    @Override
    public VehicleResource updateVehicle(VehicleResource vehicleResource, Long id) {
        return vehicleRepository.findById(id)
        .map(vehicle -> {
            vehicle.setEstado(vehicleResource.getEstadoVehiculo());
            vehicle.setImagen(vehicleResource.getImagen());
            vehicle.setPrecioAlquiler(vehicleResource.getPrecioAlquiler());
            return vehicleMapper.vehicleToVehicleResource(vehicleRepository.save(vehicle));
        }).orElseThrow(() -> new VehicleNotFoundException(id));
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.delete(vehicleRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id)));
    }
}
