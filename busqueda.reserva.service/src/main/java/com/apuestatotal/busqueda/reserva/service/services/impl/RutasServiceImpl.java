package com.apuestatotal.busqueda.reserva.service.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestatotal.busqueda.reserva.service.dto.RutaDTO;
import com.apuestatotal.busqueda.reserva.service.mapper.impl.RutaMapper;
import com.apuestatotal.busqueda.reserva.service.model.RutaBO;
import com.apuestatotal.busqueda.reserva.service.repository.IRutaRepository;
import com.apuestatotal.busqueda.reserva.service.services.generic.IRutasService;

/**
 * <p>
 * Clase que implementa la interfaz IRutasService
 * </p>
 * 
 * @author: itocto
 * @date: 2024-03-23
 * @version: 1.0
 */
@Service
public class RutasServiceImpl implements IRutasService {

    private static final Logger logger = LogManager.getLogger(RutasServiceImpl.class);
    @Autowired
    private IRutaRepository rutaRepository;

    @Autowired
    private RutaMapper rutaMapper;

    /**
     * Obtiene las rutas por origen, destino y fecha
     * 
     * @param origen
     * @param destino
     * @param fecha
     * @return
     * @throws Exception
     */
    @Override
    public List<RutaDTO> getRutasByOrigenAndDestinoAndFecha(String origen, String destino, String fecha)
            throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresando a getRutasByOrigenAndDestinoAndFecha");

        List<RutaDTO> rutas = new ArrayList<>();

        try {
            List<RutaBO> rutasResp = rutaRepository.findByOrigenAndDestinoAndFecha(origen, destino,
                    Date.valueOf(fecha));

            for (RutaBO rutaBO : rutasResp) {

                RutaDTO rutaDTO = rutaMapper.toDTO(rutaBO);
                rutas.add(rutaDTO);
            }

        } catch (Exception e) {
            logger.error("Error al obtener las rutas por origen, destino y fecha", e);
            throw e;
        }

        logger.info(this.getClass().getSimpleName() + "Saliendo de getRutasByOrigenAndDestinoAndFecha");
        return rutas;
    }

}
