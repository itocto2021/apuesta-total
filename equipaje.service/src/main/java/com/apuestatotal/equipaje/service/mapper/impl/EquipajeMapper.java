package com.apuestatotal.equipaje.service.mapper.impl;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.apuestatotal.equipaje.service.dto.EquipajeDTO;
import com.apuestatotal.equipaje.service.mapper.generic.IGenericMapper;
import com.apuestatotal.equipaje.service.model.EquipajeBO;
import com.apuestatotal.equipaje.service.model.ReservaBO;

@Component
public class EquipajeMapper implements IGenericMapper<EquipajeDTO, EquipajeBO> {

    @Override
    public EquipajeDTO toDTO(EquipajeBO bo) {

        if (Objects.isNull(bo))
            return null;

        Long id = Objects.isNull(bo.getId()) ? null : bo.getId();
        Long reserva = Objects.isNull(bo.getReserva()) ? null : bo.getReserva().getId();
        String descripcion = Objects.isNull(bo.getDescripcion()) ? null : bo.getDescripcion();
        double peso = Objects.isNull(bo.getPeso()) ? 0 : bo.getPeso();

        return new EquipajeDTO(id, reserva, descripcion, peso);
    }

    @Override
    public EquipajeBO toBO(EquipajeDTO dto) {

        if (Objects.isNull(dto))
            return null;

        Long id = Objects.isNull(dto.getId()) ? null : dto.getId();
        Long reserva = Objects.isNull(dto.getReserva()) ? null : dto.getReserva();
        String descripcion = Objects.isNull(dto.getDescripcion()) ? null : dto.getDescripcion();
        double peso = Objects.isNull(dto.getPeso()) ? 0 : dto.getPeso();

        ReservaBO reservaBO = new ReservaBO();
        reservaBO.setId(reserva);

        return new EquipajeBO(id, reservaBO, descripcion, peso);
    }

}
