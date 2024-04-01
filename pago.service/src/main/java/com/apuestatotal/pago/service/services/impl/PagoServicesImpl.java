package com.apuestatotal.pago.service.services.impl;

import com.apuestatotal.pago.service.model.ReservaBO;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestatotal.pago.service.dto.PagoDTO;
import com.apuestatotal.pago.service.mapper.PagoMapper;
import com.apuestatotal.pago.service.model.PagoBO;
import com.apuestatotal.pago.service.repository.IPagoRepository;
import com.apuestatotal.pago.service.services.generic.IPagoServices;

import jakarta.transaction.Transactional;

import java.util.Objects;

@Service
public class PagoServicesImpl implements IPagoServices {
    public static final Logger logger = LogManager.getLogger(PagoServicesImpl.class);

    @Autowired
    private IPagoRepository pagoRepository;

    @Autowired
    private PagoMapper pagoMapper;

    @Transactional
    @Override
    public PagoDTO savePago(PagoDTO pago) throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresando a savePago");

        PagoDTO respDto = null;

        try {
            PagoBO bo = pagoMapper.toBO(pago);
            PagoBO savedPagoBO = pagoRepository.save(bo);
            respDto = pagoMapper.toDTO(savedPagoBO);

        } catch (Exception e) {
            throw new Exception("Error al guardar el pago: " + e.getMessage());
        }

        logger.info(this.getClass().getSimpleName() + "Saliendo de savePago");
        return respDto;
    }

    @Override
    public Boolean deletePago(Long id) throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresando a deletePago");
        try {

            ReservaBO  reserva = new ReservaBO();
            reserva.setId(id);

            PagoBO pago = pagoRepository.findByReserva(reserva);

            if (Objects.nonNull(pago)) {
                pagoRepository.deleteById(pago.getId());
            }

            logger.info(this.getClass().getSimpleName() + "Saliendo de deletePago");
            return true;
        } catch (Exception e) {
            throw new Exception("Error al eliminar el pago: " + e.getMessage());
        }
    }
}
