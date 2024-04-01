package com.apuestatotal.orquestador.controller;

import com.apuestatotal.orquestador.dto.RequestCompraDTO;
import com.apuestatotal.orquestador.services.generic.IOrquestadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/comprar-vuelo")
public class ComprarVueloController {

    private final IOrquestadorService orquestadorService;

    public ComprarVueloController(IOrquestadorService orquestadorService) {
        this.orquestadorService = orquestadorService;
    }

    @PostMapping()
    public ResponseEntity<?> comprarVuelo(@RequestBody RequestCompraDTO requestCompraDTO)
            throws Exception {

        try {
            orquestadorService.realizarCompra(requestCompraDTO);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al realizar la compra");
        }
        return ResponseEntity.ok("Compra realizada correctamente");
    }
}
