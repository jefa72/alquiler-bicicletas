package com.jesoftware.alquilerbicicletas.controllers;

import com.jesoftware.alquilerbicicletas.resources.VehicleResource;
import com.jesoftware.alquilerbicicletas.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    VehicleResource saveVehicle(@Valid @RequestBody VehicleResource vehicleResource) {
        return vehicleService.saveVehicle(vehicleResource);
    }

    @GetMapping("/{id}")
    VehicleResource getVehicle(@PathVariable Long id) {
        return vehicleService.getVehicle(id);
    }

    @GetMapping
    List<VehicleResource> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping("/rented/{dateStr}")
    List<VehicleResource> getRentedVehicles(@PathVariable String dateStr) {
        return vehicleService.getRentedVehicles(dateStr);
    }

    @GetMapping("/free/{dateStr}")
    List<VehicleResource> getFreeVehicles(@PathVariable String dateStr) {
        return vehicleService.getFreeVehicles(dateStr);
    }
}
