package com.apuestatotal.busqueda.reserva.service.services.generic;

import java.util.List;

import com.apuestatotal.busqueda.reserva.service.dto.RutaDTO;

/**
 * <p>
 * Interfaz que define los métodos para obtener las rutas por origen, destino y
 * fecha.
 * </p>
 * 
 * @author: itocto
 * @date: 2024-03-23
 * @version: 1.0
 * 
 */
public interface IRutasService {

    /**
     * <p>
     * Método que obtiene las rutas por origen, destino y fecha.
     * </p>
     * 
     * @param origen
     * @param destino
     * @param fecha
     * @return {@Link List<RutaDTO>}
     * @throws Exception
     */
    List<RutaDTO> getRutasByOrigenAndDestinoAndFecha(String origen, String destino, String fecha) throws Exception;
}
