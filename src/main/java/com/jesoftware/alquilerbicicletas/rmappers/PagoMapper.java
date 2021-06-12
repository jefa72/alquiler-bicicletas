package com.jesoftware.alquilerbicicletas.rmappers;

import com.jesoftware.alquilerbicicletas.domain.Pago;
import com.jesoftware.alquilerbicicletas.resources.PagoResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagoMapper {

    Pago pagoResourceToPago(PagoResource pagoResource);

    PagoResource pagoToPagoResource(Pago pago);

}
