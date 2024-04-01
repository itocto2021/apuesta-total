package com.apuestatotal.busqueda.reserva.service.mapper.impl;

import java.sql.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.apuestatotal.busqueda.reserva.service.dto.RutaDTO;
import com.apuestatotal.busqueda.reserva.service.mapper.generic.IGenericMapper;
import com.apuestatotal.busqueda.reserva.service.model.RutaBO;


@Component
public class RutaMapper implements IGenericMapper<RutaDTO, RutaBO>{

    @Override
    public RutaDTO toDTO(RutaBO bo) {
        
        if (bo == null) {
            return null;
        }

        Long id = Objects.isNull(bo.getId()) ? null : bo.getId();
        String origen = Objects.isNull(bo.getOrigen()) ? null : bo.getOrigen();
        String destino = Objects.isNull(bo.getDestino()) ? null : bo.getDestino();
        String fecha = Objects.isNull(bo.getFecha()) ? null : bo.getFecha().toString();


        return new RutaDTO(origen, destino, fecha, id);
    }

    @Override
    public RutaBO toBO(RutaDTO dto) {
            
            if (dto == null) {
                return null;
            }
    
            Long id = Objects.isNull(dto.getRutaId()) ? null : dto.getRutaId();
            String origen = Objects.isNull(dto.getOrigen()) ? null : dto.getOrigen();
            String destino = Objects.isNull(dto.getDestino()) ? null : dto.getDestino();
            String fecha = Objects.isNull(dto.getFecha()) ? null : dto.getFecha();
    
            return new RutaBO(id, origen, destino, Date.valueOf(fecha));
    }
    
}
