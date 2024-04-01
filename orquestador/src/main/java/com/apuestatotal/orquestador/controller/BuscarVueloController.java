package com.apuestatotal.orquestador.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apuestatotal.orquestador.controller.generic.CustomResponse;
import com.apuestatotal.orquestador.services.generic.rest.IBuscarYReservarRutaService;

@RestController
@RequestMapping("/buscar-vuelo")
public class BuscarVueloController {
    private static final Logger logger = LogManager.getLogger(BuscarVueloController.class);

    @Autowired
    private IBuscarYReservarRutaService rutasService;


    @GetMapping
    public ResponseEntity<?> getRutasByOrigenAndDestinoAndFecha(
            @RequestParam String origen,
            @RequestParam String destino,
            @RequestParam String fecha) throws Exception {
        logger.info(this.getClass().getSimpleName() + "Ingresando a getRutasByOrigenAndDestinoAndFecha");
        CustomResponse respRutas = new CustomResponse();
        try {
            respRutas = rutasService.buscarRuta(origen, destino, fecha);

        } catch (Exception e) {
            logger.error(
                    this.getClass().getSimpleName() + "Error en getRutasByOrigenAndDestinoAndFecha: " + e.getMessage());
            throw new Exception(e);
        }
        return ResponseEntity.ok(respRutas);
    }
}
