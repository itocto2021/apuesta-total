package com.apuestatotal.busqueda.reserva.service.services.generic;

import com.apuestatotal.busqueda.reserva.service.dto.ReservaDTO;
import com.apuestatotal.busqueda.reserva.service.exceptions.ReservaException;

/**
 * <p>
 * Interfaz que define los métodos para guardar una reserva.
 * </p>
 * 
 * @author: itocto
 * @date: 2024-03-23
 * @version: 1.0
 * 
 */
public interface IReservasService {

    /**
     * <p>
     * Método que guarda una reserva.
     * </p>
     * 
     * @param reserva
     * @return
     * @throws ReservaException
     */
    ReservaDTO saveReserva(ReservaDTO reserva) throws ReservaException;

    ReservaDTO updateReserva(ReservaDTO reserva) throws ReservaException;

    Boolean deleteReserva(Long id) throws ReservaException;
}
