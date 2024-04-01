package com.apuestatotal.seleccion.asientos.service.services.impl;

import com.apuestatotal.seleccion.asientos.service.model.ReservaBO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestatotal.seleccion.asientos.service.dto.AsientoDTO;
import com.apuestatotal.seleccion.asientos.service.mapper.impl.AsientosMapper;
import com.apuestatotal.seleccion.asientos.service.model.AsientoBO;
import com.apuestatotal.seleccion.asientos.service.repository.IAsientoRepository;
import com.apuestatotal.seleccion.asientos.service.services.generic.IAsientoServices;

import jakarta.transaction.Transactional;

import java.util.Objects;

@Service
public class AsientoServicesImpl implements IAsientoServices {
    public static  final Logger logger = LogManager.getLogger(AsientoServicesImpl.class);
    @Autowired
    private IAsientoRepository asientoRepository;

    @Autowired
    private AsientosMapper asientoMapper;

    @Transactional
    @Override
    public AsientoDTO saveAsiento(AsientoDTO asiento) throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresando a saveAsiento");
        AsientoDTO respDto = null;

        try {
            AsientoBO bo = asientoMapper.toBO(asiento);
            AsientoBO savedAsientoBO = asientoRepository.save(bo);
            respDto = asientoMapper.toDTO(savedAsientoBO);

        } catch (Exception e) {
            throw new Exception("Error al guardar el asiento: " + e.getMessage());
        }
        logger.info(this.getClass().getSimpleName() + "Saliendo de saveAsiento");
        return respDto;
    }

    @Override
    public Boolean deleteAsiento(Long id) throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresando a deleteAsiento");
        try {

            ReservaBO reserva = new ReservaBO();
            reserva.setId(id);

            AsientoBO asiento = asientoRepository.findByReserva(reserva);
            if (Objects.nonNull(asiento)) {
                asientoRepository.deleteById(asiento.getId());
            }

            logger.info(this.getClass().getSimpleName() + "Saliendo de deleteAsiento");
            return true;
        } catch (Exception e) {
            throw new Exception("Error al eliminar el asiento: " + e.getMessage());
        }
    }
}
