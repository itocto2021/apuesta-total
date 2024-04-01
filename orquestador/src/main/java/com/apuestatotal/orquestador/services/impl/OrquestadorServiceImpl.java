package com.apuestatotal.orquestador.services.impl;

import org.springframework.stereotype.Service;

import com.apuestatotal.orquestador.dto.PagoDTO;
import com.apuestatotal.orquestador.dto.RequestCompraDTO;
import com.apuestatotal.orquestador.services.generic.ICompensacionService;
import com.apuestatotal.orquestador.services.generic.IOrquestadorService;
import com.apuestatotal.orquestador.services.generic.rest.IAnadirEquipajeService;
import com.apuestatotal.orquestador.services.generic.rest.IBuscarYReservarRutaService;
import com.apuestatotal.orquestador.services.generic.rest.IEmitirBoletoService;
import com.apuestatotal.orquestador.services.generic.rest.IProcesarPagoService;
import com.apuestatotal.orquestador.services.generic.rest.ISeleccionarAsientosService;

@Service
public class OrquestadorServiceImpl implements IOrquestadorService {

    private final IBuscarYReservarRutaService reservarVuelo;

    private final ISeleccionarAsientosService seleccionarAsiento;

    private final IAnadirEquipajeService anadirEquipaje;

    private final IProcesarPagoService realizarPago;

    private final IEmitirBoletoService emitirBoletoService;

    private final ICompensacionService compensacionService;

    public OrquestadorServiceImpl(IBuscarYReservarRutaService reservarVuelo,
                                  ISeleccionarAsientosService seleccionarAsiento, IAnadirEquipajeService anadirEquipaje,
                                  IProcesarPagoService realizarPago, IEmitirBoletoService emitirBoletoService, ICompensacionService compensacionService) {
        this.reservarVuelo = reservarVuelo;
        this.seleccionarAsiento = seleccionarAsiento;
        this.anadirEquipaje = anadirEquipaje;
        this.realizarPago = realizarPago;
        this.emitirBoletoService = emitirBoletoService;
        this.compensacionService = compensacionService;
    }

    @Override
    public Boolean realizarCompra(RequestCompraDTO resquest) throws Exception {

        Long idReserva = null;
        boolean result = false;
        try {

            // reservar vuelo
            idReserva = reservarVuelo.reservarVuelo(resquest.getReserva()).getRecervaId();

            // asignar reserva a los objetos
            resquest.getAsiento().setReserva(idReserva);
            resquest.getEquipaje().setReserva(idReserva);
            resquest.getPago().setReserva(idReserva);

            // anadir equipaje
            anadirEquipaje.anadirEquipaje(resquest.getEquipaje());

            // seleccionar asiento
            seleccionarAsiento.seleccionarAsiento(resquest.getAsiento());

            // pagar
            PagoDTO respPago = realizarPago.procesarPago(resquest.getPago());

            // confirmar reserva
            reservarVuelo.confirmarReservaVuelo(idReserva);

            // emitir boleto
            emitirBoletoService.emitirBoleto(respPago);

            result = true;

        } catch (Exception e) {
            compensacionService.rollback(idReserva);
            throw new Exception("Error al realizar la compra");
        }

        return result;
    }

}
