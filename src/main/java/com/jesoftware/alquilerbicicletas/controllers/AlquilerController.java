package com.jesoftware.alquilerbicicletas.controllers;

import com.jesoftware.alquilerbicicletas.resources.AlquilerResource;
import com.jesoftware.alquilerbicicletas.service.AlquilerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/alquiler")
@AllArgsConstructor
public class AlquilerController {

    private final AlquilerService alquilerService;

    @PostMapping
    AlquilerResource saveAlquiler(@Valid @RequestBody AlquilerResource alquilerResource) {
        return alquilerService.saveAlquiler(alquilerResource);
    }

}
