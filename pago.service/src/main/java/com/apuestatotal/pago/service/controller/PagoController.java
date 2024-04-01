package com.apuestatotal.pago.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apuestatotal.pago.service.controller.generic.GenericController;
import com.apuestatotal.pago.service.dto.PagoDTO;
import com.apuestatotal.pago.service.services.generic.IPagoServices;

@RestController
@RequestMapping("/pago")
public class PagoController extends GenericController {
    
    @Autowired
    private IPagoServices pagoService;

    @PostMapping()
    public ResponseEntity<?> savePago(@RequestBody PagoDTO pago)
            throws Exception {

        try {
            PagoDTO savedPago = pagoService.savePago(pago);
            return super.getCreated(savedPago, "Pago guardado correctamente");

        } catch (Exception e) {
            return super.getError(e.getMessage(), "/pago");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePago(@PathVariable Long id) throws Exception {

        try {
            pagoService.deletePago(id);
            return super.getOk(Boolean.TRUE,"Pago eliminado correctamente");
        } catch (Exception e) {
            return super.getError("Error al eliminar el pago", "/pago");
        }
    }
}
