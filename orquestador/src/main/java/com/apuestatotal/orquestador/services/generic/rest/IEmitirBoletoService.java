package com.apuestatotal.orquestador.services.generic.rest;

import com.apuestatotal.orquestador.dto.BoletoDTO;
import com.apuestatotal.orquestador.dto.PagoDTO;

public interface IEmitirBoletoService {
    BoletoDTO emitirBoleto(PagoDTO pago);
    void deshacerEmitirBoleto(Long idReserva);
}
