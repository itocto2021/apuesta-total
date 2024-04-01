package com.apuestatotal.seleccion.asientos.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apuestatotal.seleccion.asientos.service.controller.generic.GenericController;
import com.apuestatotal.seleccion.asientos.service.dto.AsientoDTO;
import com.apuestatotal.seleccion.asientos.service.services.generic.IAsientoServices;

@RestController
@RequestMapping("/asiento")
public class AsientoController extends GenericController {
    @Autowired
    private IAsientoServices asientoService;

    @PostMapping()
    public ResponseEntity<?> saveAsiento(@RequestBody AsientoDTO asiento)
            throws Exception {

        try {
            AsientoDTO savedAsiento = asientoService.saveAsiento(asiento);
            return super.getCreated(savedAsiento, "Asiento guardado correctamente");
        } catch (Exception e) {
            return super.getError(e.getMessage(), "/asiento");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAsiento(@PathVariable Long id)
            throws Exception {

        try {
            asientoService.deleteAsiento(id);
            return super.getCreated(Boolean.TRUE, "Asiento eliminado correctamente");
        } catch (Exception e) {
            return super.getError(e.getMessage(), "/asiento");
        }
    }
}
