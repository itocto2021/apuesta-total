package com.apuestatotal.orquestador.services.impl.rest;

import org.springframework.stereotype.Service;

import com.apuestatotal.orquestador.controller.generic.CustomResponse;
import com.apuestatotal.orquestador.dto.BoletoDTO;
import com.apuestatotal.orquestador.dto.EquipajeDTO;
import com.apuestatotal.orquestador.dto.PagoDTO;
import com.apuestatotal.orquestador.services.GenericRestClientImpl;
import com.apuestatotal.orquestador.services.generic.rest.IEmitirBoletoService;
import com.apuestatotal.orquestador.utils.Utilidades;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Service
public class EmitirBoletoServiceImpl implements IEmitirBoletoService {

    private final GenericRestClientImpl restClient;

    public EmitirBoletoServiceImpl(GenericRestClientImpl restClient) {
        this.restClient = restClient;
    }

    @Override
    public BoletoDTO emitirBoleto(PagoDTO pagoDTO) {

        BoletoDTO boletoDTO = new BoletoDTO();
        boletoDTO.setPago(pagoDTO.getId());

        String url = Utilidades.formatUrlPost(8084, "/servicio-emision-boletos/boleto");
        Mono<CustomResponse> resMono = restClient.postCallEndpoint(url, boletoDTO, CustomResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        BoletoDTO boleto = mapper.convertValue(resMono.block().getData(), BoletoDTO.class);

        return boleto;
    }

    @Override
    public void deshacerEmitirBoleto(Long idReserva) {
        String url = Utilidades.formatUrlPost(8084, "/servicio-emision-boletos/boleto");
        Mono<CustomResponse> resMono = restClient.deleteEndpoint(url, idReserva, CustomResponse.class);
        resMono.block();
    }
}
