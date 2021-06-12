package com.jesoftware.alquilerbicicletas.rmappers;

import com.jesoftware.alquilerbicicletas.domain.Alquiler;
import com.jesoftware.alquilerbicicletas.domain.User;
import com.jesoftware.alquilerbicicletas.domain.Vehicle;
import com.jesoftware.alquilerbicicletas.resources.AlquilerResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AlquilerMapper {

    @Mappings({
            @Mapping(target = "fechaAlquiler", source = "alquilerResource.fechaAlquilerStr", dateFormat = "dd-MM-yyyy"),
            @Mapping(target = "fechaDevolucion", source = "alquilerResource.fechaDevolucionStr", dateFormat = "dd-MM-yyyy"),
            @Mapping(target = "vehicle", source = "vehicle"),
            @Mapping(target = "user", source = "user")
    })
    Alquiler alquilerResourceToAlquiler(AlquilerResource alquilerResource, Vehicle vehicle, User user);

    @Mappings({
            @Mapping(target = "fechaAlquilerStr", source = "alquiler.fechaAlquiler", dateFormat = "dd-MM-yyyy"),
            @Mapping(target = "fechaDevolucionStr", source = "alquiler.fechaDevolucion", dateFormat = "dd-MM-yyyy"),
            @Mapping(target = "vehicleId", source = "vehicle.vehicleId"),
            @Mapping(target = "userId", source = "user.user_Id")
    })
    AlquilerResource alquilerToAlquilerResource(Alquiler alquiler, Vehicle vehicle, User user);

}
