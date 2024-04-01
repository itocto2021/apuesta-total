package com.apuestatotal.orquestador.services.impl.rest;

import org.springframework.stereotype.Service;

import com.apuestatotal.orquestador.controller.generic.CustomResponse;
import com.apuestatotal.orquestador.dto.PagoDTO;
import com.apuestatotal.orquestador.services.GenericRestClientImpl;
import com.apuestatotal.orquestador.services.generic.rest.IProcesarPagoService;
import com.apuestatotal.orquestador.utils.Utilidades;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Service
public class ProcesarPagoServiceImpl implements IProcesarPagoService {

    private final GenericRestClientImpl restClient;

    public ProcesarPagoServiceImpl(GenericRestClientImpl restClient) {
        this.restClient = restClient;
    }

    @Override
    public PagoDTO procesarPago(PagoDTO pagoDTO) {
        String url = Utilidades.formatUrlPost(8083, "/servicio-pago/pago");
        Mono<CustomResponse> resMono = restClient.postCallEndpoint(url, pagoDTO, CustomResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        PagoDTO pago = mapper.convertValue(resMono.block().getData(), PagoDTO.class);

        return pago;
    }

    @Override
    public void deshacerProcesarPago(Long idReserva) {
        String url = Utilidades.formatUrlPost(8083, "/servicio-pago/pago");
        Mono<CustomResponse> resMono = restClient.deleteEndpoint(url, idReserva, CustomResponse.class);
        resMono.block();
    }
}
