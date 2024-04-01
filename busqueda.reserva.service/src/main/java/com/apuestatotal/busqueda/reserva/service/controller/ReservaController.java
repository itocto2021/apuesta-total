package com.apuestatotal.busqueda.reserva.service.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.apuestatotal.busqueda.reserva.service.controller.generic.GenericController;
import com.apuestatotal.busqueda.reserva.service.dto.ReservaDTO;
import com.apuestatotal.busqueda.reserva.service.services.generic.IReservasService;

@RestController
@RequestMapping("/reservas")
public class ReservaController extends GenericController {
    public static final Logger logger = LogManager.getLogger(ReservaController.class);

    @Autowired
    private IReservasService reservasService;

    @PostMapping
    public ResponseEntity<?> saveReserva(@Valid @RequestBody ReservaDTO reserva, BindingResult result)
            throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresando a saveReserva");

        if (result.hasErrors()) {
            return super.getErrors(result);
        }

        try {

            ReservaDTO savedReserva = reservasService.saveReserva(reserva);

            logger.info(this.getClass().getSimpleName() + "Saliendo de saveReserva");
            return super.getCreated(savedReserva, "Reserva guardada correctamente");

        } catch (Exception e) {
            logger.error("Error al guardar la reserva: ", e);
            return super.getError(e.getMessage(), "Error al guardar la reserva");
        }
    }

    @PutMapping
    public ResponseEntity<?> updateReserva(@Valid @RequestBody ReservaDTO reserva, BindingResult result)
            throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresando a updateReserva");

        if (result.hasErrors()) {
            return super.getErrors(result);
        }

        try {

            ReservaDTO updatedReserva = reservasService.updateReserva(reserva);

            logger.info(this.getClass().getSimpleName() + "Saliendo de updateReserva");
            return super.getCreated(updatedReserva, "Reserva actualizada correctamente");

        } catch (Exception e) {
            return super.getError(e.getMessage(), "Error al actualizar la reserva");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReserva(@PathVariable Long id) throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresando a deleteReserva");

        try {

            reservasService.deleteReserva(id);

            logger.info(this.getClass().getSimpleName() + "Saliendo de deleteReserva");
            return super.getOk(Boolean.TRUE, "Reserva eliminada correctamente");

        } catch (Exception e) {
            return super.getError(e.getMessage(), "Error al eliminar la reserva");
        }
    }
}
