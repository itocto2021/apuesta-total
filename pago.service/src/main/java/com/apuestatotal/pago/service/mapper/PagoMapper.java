package com.apuestatotal.pago.service.mapper;

import com.apuestatotal.pago.service.model.ReservaBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.apuestatotal.pago.service.dto.PagoDTO;
import com.apuestatotal.pago.service.model.PagoBO;

@Mapper(componentModel = "spring")
public interface PagoMapper {

    PagoMapper INSTANCE = Mappers.getMapper(PagoMapper.class);

    @Mapping(source = "reserva", target = "reserva", qualifiedByName = "getReservaId")
    PagoDTO toDTO(PagoBO pagoBO);

    @Mapping(source = "reserva", target = "reserva", qualifiedByName = "getReserva")
    PagoBO toBO(PagoDTO pagoDTO);

    @Named("getReservaId")
    default Long getReservaId(ReservaBO reservaBO) {
        return reservaBO.getId();
    }

    @Named("getReserva")
    default ReservaBO getReserva(Long id) {
        ReservaBO reservaBO = new ReservaBO();
        reservaBO.setId(id);
        return reservaBO;
    }

}
