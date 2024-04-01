package com.apuestatotal.orquestador.services.generic.rest;


import com.apuestatotal.orquestador.dto.EquipajeDTO;

public interface IAnadirEquipajeService {
    EquipajeDTO anadirEquipaje(EquipajeDTO equipajeDTO);
    void deshacerAnadirEquipaje(Long idReserva);
}
