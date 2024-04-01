package com.apuestatotal.busqueda.reserva.service.mapper.impl;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.apuestatotal.busqueda.reserva.service.dto.ReservaDTO;
import com.apuestatotal.busqueda.reserva.service.mapper.generic.IGenericMapper;
import com.apuestatotal.busqueda.reserva.service.model.ReservaBO;
import com.apuestatotal.busqueda.reserva.service.model.RutaBO;

@Component
public class ReservaMapper implements IGenericMapper<ReservaDTO, ReservaBO> {

    @Override
    public ReservaDTO toDTO(ReservaBO bo) {

        if (Objects.isNull(bo))
            return null;

        Long recervaId = Objects.isNull(bo.getId()) ? null : bo.getId();
        Long ruta = Objects.isNull(bo.getRuta()) ? null : bo.getRuta().getId();
        int cantidadAsientos = Objects.isNull(bo.getCantidadAsientos()) ? 0 : bo.getCantidadAsientos();
        char estado = Objects.isNull(bo.getEstado()) ? ' ' : bo.getEstado();
        String fechaCreacion = Objects.isNull(bo.getFechaCreacion()) ? null : bo.getFechaCreacion().toString();
        String fechaModificacion = Objects.isNull(bo.getFechaModificacion()) ? null : bo.getFechaModificacion().toString();

        return new ReservaDTO(recervaId, ruta, cantidadAsientos, estado, fechaCreacion, fechaModificacion);
    }

    @Override
    public ReservaBO toBO(ReservaDTO dto) {

        if (Objects.isNull(dto))
            return null;

        Long recervaId = Objects.isNull(dto.getRecervaId()) ? null : dto.getRecervaId();
        Long rutaId = Objects.isNull(dto.getRuta()) ? null : dto.getRuta();
        int cantidadAsientos = Objects.isNull(dto.getCantidadAsientos()) ? 0 : dto.getCantidadAsientos();
        char estado = Objects.isNull(dto.getEstado()) ? ' ' : dto.getEstado();

        RutaBO rutaBO = new RutaBO();
        rutaBO.setId(rutaId);

        return new ReservaBO(recervaId, rutaBO, cantidadAsientos, estado, LocalDateTime.now(), null);
    }

}
