package com.apuestatotal.emision.boletos.service.services.impl;

import com.apuestatotal.emision.boletos.service.dto.BoletoDTO;
import com.apuestatotal.emision.boletos.service.mapper.BoletoMapper;
import com.apuestatotal.emision.boletos.service.model.BoletoBO;
import com.apuestatotal.emision.boletos.service.model.PagoBO;
import com.apuestatotal.emision.boletos.service.model.ReservaBO;
import com.apuestatotal.emision.boletos.service.repository.IBoletoRepository;
import com.apuestatotal.emision.boletos.service.repository.IPagoRepository;
import com.apuestatotal.emision.boletos.service.services.generic.IBoletoService;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
public class BoletoServiceImpl implements IBoletoService {

    public static final Logger logger = LogManager.getLogger(BoletoServiceImpl.class);
    private final IBoletoRepository boletoRepository;

    private final IPagoRepository pagoRepository;

    private final BoletoMapper boletoMapper;

    public BoletoServiceImpl(IBoletoRepository boletoRepository, IPagoRepository pagoRepository, BoletoMapper boletoMapper) {
        this.boletoRepository = boletoRepository;
        this.pagoRepository = pagoRepository;
        this.boletoMapper = boletoMapper;
    }

    @Transactional
    @Override
    public BoletoDTO saveBoleto(BoletoDTO boleto) throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresaba al metodo saveBoleto");

        BoletoDTO respDto = null;

        try {


            BoletoBO bo = boletoMapper.toBO(boleto);
            bo.setCodigo(generateBoletaNumber());
            BoletoBO savedBoletoBO = boletoRepository.save(bo);
            respDto = boletoMapper.toDTO(savedBoletoBO);

        } catch (Exception e) {
            throw new Exception("Error al guardar el boleto: " + e.getMessage());
        }

        logger.info(this.getClass().getSimpleName() + "Saliendo del metodo saveBoleto");
        return respDto;
    }

    @Override
    public Boolean deleteBoleto(Long id) throws Exception {
        logger.info(this.getClass().getSimpleName() + " Ingresaba al metodo deleteBoleto");
        try {

            ReservaBO reserva = new ReservaBO();
            reserva.setId(id);
            PagoBO pago = pagoRepository.findByReserva(reserva);

            if (Objects.nonNull(pago)) {
                BoletoBO boleto = boletoRepository.findByPago(pago);

                if (Objects.nonNull(boleto)) {
                    boletoRepository.deleteById(boleto.getId());
                }
            }
            logger.info(this.getClass().getSimpleName() + "Saliendo del metodo deleteBoleto");
            return true;
        } catch (Exception e) {
            throw new Exception("Error al eliminar el boleto: " + e.getMessage());
        }
    }

    private static final Random RANDOM = new Random();

    public static String generateBoletaNumber() {
        int randomNumber = RANDOM.nextInt(10000);
        return String.format("E001-%04d", randomNumber);
    }
}
