package com.jesoftware.alquilerbicicletas.rmappers;

import com.jesoftware.alquilerbicicletas.domain.Vehicle;
import com.jesoftware.alquilerbicicletas.resources.VehicleResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(source = "estadoVehiculo", target = "estado")
    Vehicle vehicleResourceToVehicle(VehicleResource vehicleResource);

    @Mapping(source = "estado", target = "estadoVehiculo")
    VehicleResource vehicleToVehicleResource(Vehicle vehicle);
    List<VehicleResource> vehicleToVehicleResourceList(List<Vehicle> vehicles);
}
