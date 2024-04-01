package com.apuestatotal.orquestador.services.generic.rest;


import com.apuestatotal.orquestador.dto.AsientoDTO;

public interface ISeleccionarAsientosService {
    AsientoDTO seleccionarAsiento(AsientoDTO asientoDTO);
    void deshacerSeleccionarAsiento(Long idReserva);
}
