package com.apuestatotal.orquestador.services.generic.rest;

import com.apuestatotal.orquestador.controller.generic.CustomResponse;
import com.apuestatotal.orquestador.dto.ReservaDTO;

public interface IBuscarYReservarRutaService {

    CustomResponse buscarRuta(String origen, String destino, String fecha);
    ReservaDTO reservarVuelo(ReservaDTO datosCompra);
    void confirmarReservaVuelo(Long idReserva);
    void deshacerReservarVuelo(Long idReserva);
}
