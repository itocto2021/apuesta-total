package com.apuestatotal.seleccion.asientos.service.mapper.impl;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.apuestatotal.seleccion.asientos.service.dto.AsientoDTO;
import com.apuestatotal.seleccion.asientos.service.mapper.generic.IGenericMapper;
import com.apuestatotal.seleccion.asientos.service.model.AsientoBO;
import com.apuestatotal.seleccion.asientos.service.model.ReservaBO;

@Component
public class AsientosMapper implements IGenericMapper<AsientoDTO, AsientoBO> {

    @Override
    public AsientoDTO toDTO(AsientoBO bo) {
        if (Objects.isNull(bo))
            return null;

        Long id = Objects.isNull(bo.getId()) ? null : bo.getId();
        Long reserva = Objects.isNull(bo.getReserva()) ? null : bo.getReserva().getId();
        String numero = Objects.isNull(bo.getNumero()) ? null : bo.getNumero();

        return new AsientoDTO(id, reserva, numero);

    }

    @Override
    public AsientoBO toBO(AsientoDTO dto) {

        if (Objects.isNull(dto))
            return null;

        Long id = Objects.isNull(dto.getId()) ? null : dto.getId();
        Long reserva = Objects.isNull(dto.getReserva()) ? null : dto.getReserva();
        String numero = Objects.isNull(dto.getNumero()) ? null : dto.getNumero();

        ReservaBO reservaBO = new ReservaBO();
        reservaBO.setId(reserva);

        return new AsientoBO(id, reservaBO, numero);
    }

}
