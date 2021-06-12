package com.jesoftware.alquilerbicicletas.service;

import com.jesoftware.alquilerbicicletas.resources.VehicleResource;

import java.util.List;

public interface VehicleService {
    public VehicleResource saveVehicle(VehicleResource vehicle);
    public List<VehicleResource> getVehicles();
    public List<VehicleResource> getRentedVehicles(String dateStr);
    public List<VehicleResource> getFreeVehicles(String dateStr);
    public VehicleResource getVehicle(Long id);
    public VehicleResource updateVehicle(VehicleResource vehicle, Long id);
    public void deleteVehicle(Long id);
}
