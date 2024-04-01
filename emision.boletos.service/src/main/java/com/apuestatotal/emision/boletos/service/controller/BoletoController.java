package com.apuestatotal.emision.boletos.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apuestatotal.emision.boletos.service.controller.generic.GenericController;
import com.apuestatotal.emision.boletos.service.dto.BoletoDTO;
import com.apuestatotal.emision.boletos.service.services.generic.IBoletoService;



@RestController
@RequestMapping("/boleto")
public class BoletoController extends GenericController {
    private final IBoletoService boletoService;

    public BoletoController(IBoletoService boletoService) {
        this.boletoService = boletoService;
    }

    @PostMapping()
    public ResponseEntity<?> saveBoleto(@RequestBody BoletoDTO boleto)
            throws Exception {

        try {
            BoletoDTO savedBoleto = boletoService.saveBoleto(boleto);
            return super.getCreated(savedBoleto, "Boleto guardado correctamente");
        } catch (Exception e) {
            return super.getError(e.getMessage(), "/boleto");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoleto(@PathVariable Long id)
            throws Exception {

        try {
            boletoService.deleteBoleto(id);
            return super.getCreated(Boolean.TRUE, "Boleto eliminado correctamente");
        } catch (Exception e) {
            return super.getError(e.getMessage(), "/boleto");
        }
    }

}
