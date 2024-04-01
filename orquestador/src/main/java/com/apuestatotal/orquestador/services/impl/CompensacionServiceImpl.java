package com.apuestatotal.orquestador.services.impl;

import org.springframework.stereotype.Service;

import com.apuestatotal.orquestador.services.generic.ICompensacionService;
import com.apuestatotal.orquestador.services.generic.rest.IAnadirEquipajeService;
import com.apuestatotal.orquestador.services.generic.rest.IBuscarYReservarRutaService;
import com.apuestatotal.orquestador.services.generic.rest.IEmitirBoletoService;
import com.apuestatotal.orquestador.services.generic.rest.IProcesarPagoService;
import com.apuestatotal.orquestador.services.generic.rest.ISeleccionarAsientosService;

@Service
public class CompensacionServiceImpl implements ICompensacionService {

    private final IBuscarYReservarRutaService reservarVuelo;

    private final ISeleccionarAsientosService seleccionarAsiento;

    private final IAnadirEquipajeService anadirEquipaje;

    private final IProcesarPagoService realizarPago;

    private final IEmitirBoletoService emitirBoletoService;

    public CompensacionServiceImpl(IBuscarYReservarRutaService reservarVuelo,
            ISeleccionarAsientosService seleccionarAsiento, IAnadirEquipajeService anadirEquipaje,
            IProcesarPagoService realizarPago, IEmitirBoletoService emitirBoletoService) {
        this.reservarVuelo = reservarVuelo;
        this.seleccionarAsiento = seleccionarAsiento;
        this.anadirEquipaje = anadirEquipaje;
        this.realizarPago = realizarPago;
        this.emitirBoletoService = emitirBoletoService;
    }

    @Override
    public void rollback(Long idReserva) {
        emitirBoletoService.deshacerEmitirBoleto(idReserva);
        realizarPago.deshacerProcesarPago(idReserva);
        anadirEquipaje.deshacerAnadirEquipaje(idReserva);
        seleccionarAsiento.deshacerSeleccionarAsiento(idReserva);
        reservarVuelo.deshacerReservarVuelo(idReserva);
    }
}
