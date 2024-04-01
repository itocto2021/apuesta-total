package com.apuestatotal.equipaje.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apuestatotal.equipaje.service.controller.generic.GenericController;
import com.apuestatotal.equipaje.service.dto.EquipajeDTO;
import com.apuestatotal.equipaje.service.services.generic.IEquipajeService;

@RestController
@RequestMapping("/equipaje")
public class EquipajeController extends GenericController {
    
    @Autowired
    private IEquipajeService equipajeService;

    @PostMapping()
    public ResponseEntity<?> saveEquipaje(@RequestBody EquipajeDTO equipaje)
            throws Exception {

        try {
            EquipajeDTO savedEquipaje = equipajeService.saveEquipaje(equipaje);

            return super.getCreated(savedEquipaje, "Equipaje guardado correctamente");

        } catch (Exception e) {
            return super.getError("Error al guardar el equipaje", "/equipaje");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEquipaje(@PathVariable Long id) throws Exception {

        try {
            Boolean deleted = equipajeService.deleteEquipaje(id);
            return super.getOk(Boolean.TRUE,"Equipaje eliminado correctamente");
        } catch (Exception e) {
            return super.getError("Error al eliminar el equipaje", "/equipaje");
        }
    }
}
