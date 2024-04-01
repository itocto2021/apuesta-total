package com.apuestatotal.busqueda.reserva.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apuestatotal.busqueda.reserva.service.controller.generic.GenericController;
import com.apuestatotal.busqueda.reserva.service.dto.RutaDTO;
import com.apuestatotal.busqueda.reserva.service.services.generic.IRutasService;

@RestController
@RequestMapping("/rutas")
public class RutasController extends GenericController {
    private static final Logger logger = LogManager.getLogger(RutasController.class);

    @Autowired
    private IRutasService rutasService;

    @GetMapping
    public ResponseEntity<?> getRutasByOrigenAndDestinoAndFecha(
            @RequestParam String origen,
            @RequestParam String destino,
            @RequestParam String fecha) throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresando a getRutasByOrigenAndDestinoAndFecha");
        List<RutaDTO> respRutas = new ArrayList<>();
        try {

            respRutas = rutasService.getRutasByOrigenAndDestinoAndFecha(origen, destino, fecha);

            if (respRutas.isEmpty()) {
                return super.getNotContent();
            }

        } catch (Exception e) {
            logger.error("Error al obtener las rutas: ", e);
            return super.getError("Error al obtener las rutas", "/rutas");
        }
        logger.info(this.getClass().getSimpleName() + "Saliendo de getRutasByOrigenAndDestinoAndFecha");
        return super.getOk(respRutas, "Rutas encontradas correctamente");
    }
}
