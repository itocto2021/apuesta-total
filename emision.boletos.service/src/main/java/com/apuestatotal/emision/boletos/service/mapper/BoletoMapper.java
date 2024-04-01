package com.apuestatotal.emision.boletos.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.apuestatotal.emision.boletos.service.dto.BoletoDTO;
import com.apuestatotal.emision.boletos.service.model.BoletoBO;
import com.apuestatotal.emision.boletos.service.model.PagoBO;

@Mapper(componentModel = "spring")
public interface BoletoMapper {

    BoletoMapper INSTANCE = Mappers.getMapper(BoletoMapper.class);

    @Mapping(source = "pago", target = "pago", qualifiedByName = "getPagoId")
    BoletoDTO toDTO(BoletoBO boletoBO);

    @Mapping(source = "pago", target = "pago", qualifiedByName = "getPago")
    BoletoBO toBO(BoletoDTO boletoDTO);

    @Named("getPagoId")
    default Long getPagoId(PagoBO pago) {
        return pago.getId();
    }

    @Named("getPago")
    default PagoBO getPago(Long id) {
        PagoBO pagoBO = new PagoBO();
        pagoBO.setId(id);
        return pagoBO;
    }

}
