package com.apuestatotal.busqueda.reserva.service.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestatotal.busqueda.reserva.service.dto.ReservaDTO;
import com.apuestatotal.busqueda.reserva.service.exceptions.ReservaException;
import com.apuestatotal.busqueda.reserva.service.mapper.impl.ReservaMapper;
import com.apuestatotal.busqueda.reserva.service.model.ReservaBO;
import com.apuestatotal.busqueda.reserva.service.repository.IReservaRepository;
import com.apuestatotal.busqueda.reserva.service.services.generic.IReservasService;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * Clase que implementa la interfaz IReservasService
 * </p>
 * 
 * @autor: itocto
 * @version: 1.0
 * @date: 2021-07-01
 * 
 */
@Service
public class ReservasServiceImpl implements IReservasService {
    public static final Logger logger = LogManager.getLogger(ReservasServiceImpl.class);

    @Autowired
    private IReservaRepository reservaRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    /**
     * <p>
     * Metodo que guarda una reserva
     * </p>
     * 
     * @param reserva
     * @return ReservaDTO
     */
    @Transactional
    @Override
    public ReservaDTO saveReserva(ReservaDTO reserva) throws ReservaException {
        logger.info(this.getClass().getSimpleName() + "Ingresando a saveReserva");

        ReservaDTO respDto = null;

        
        try {
            ReservaBO bo = reservaMapper.toBO(reserva);
            ReservaBO savedReservaBO = reservaRepository.save(bo);
            respDto = reservaMapper.toDTO(savedReservaBO);

        } catch (Exception e) {
            logger.error("Error al guardar la reserva: ", e);
            e.printStackTrace();
            throw new ReservaException("Error al guardar la reserva: " + e.getMessage());
        }

        logger.info(this.getClass().getSimpleName() + "Saliendo de saveReserva");
        return respDto;
    }

    @Override
    public ReservaDTO updateReserva(ReservaDTO reserva) throws ReservaException {
        logger.info(this.getClass().getSimpleName() + "Ingresando a updateReserva");

        try {
            ReservaBO bo = reservaRepository.findById(reserva.getRecervaId()).orElseThrow(() -> new ReservaException("Reserva no encontrada"));
            bo.setEstado('C');
            bo.setFechaModificacion(LocalDateTime.now());

            ReservaBO savedReservaBO = reservaRepository.save(bo);

            logger.info(this.getClass().getSimpleName() + "Saliendo de updateReserva");
            return reservaMapper.toDTO(savedReservaBO);
        } catch (Exception e) {
            logger.error("Error al actualizar la reserva: ", e);
            e.printStackTrace();
            throw new ReservaException("Error al actualizar la reserva: " + e.getMessage());
        }
    }

    @Override
    public Boolean deleteReserva(Long id) throws ReservaException {
        logger.info(this.getClass().getSimpleName() + "Ingresando a deleteReserva");
        try {

            ReservaBO bo = reservaRepository.findById(id).orElse(null);

            if (Objects.nonNull(bo)) {
                reservaRepository.deleteById(bo.getId());
            }

            logger.info(this.getClass().getSimpleName() + "Saliendo de deleteReserva");
            return true;
        } catch (Exception e) {
            logger.error("Error al eliminar la reserva: ", e);
            e.printStackTrace();
            throw new ReservaException("Error al eliminar la reserva: " + e.getMessage());
        }
    }


}
