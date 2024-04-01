package com.apuestatotal.orquestador.services.generic.rest;


import com.apuestatotal.orquestador.dto.PagoDTO;

public interface IProcesarPagoService {
    PagoDTO procesarPago(PagoDTO pagoDTO);
    void deshacerProcesarPago(Long idReserva);
}
