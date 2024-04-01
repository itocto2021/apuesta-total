package com.apuestatotal.orquestador.services.impl.rest;

import org.springframework.stereotype.Service;

import com.apuestatotal.orquestador.controller.generic.CustomResponse;
import com.apuestatotal.orquestador.dto.AsientoDTO;
import com.apuestatotal.orquestador.services.GenericRestClientImpl;
import com.apuestatotal.orquestador.services.generic.rest.ISeleccionarAsientosService;
import com.apuestatotal.orquestador.utils.Utilidades;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Service
public class SeleccionarAsientosServiceImpl implements ISeleccionarAsientosService {

    private final GenericRestClientImpl restClient;

    public SeleccionarAsientosServiceImpl(GenericRestClientImpl restClient) {
        this.restClient = restClient;
    }

    @Override
    public AsientoDTO seleccionarAsiento(AsientoDTO asientoDTO) {
        String url = Utilidades.formatUrlPost(8082, "/servicio-seleccionar-asiento/asiento");
        Mono<CustomResponse> resMono = restClient.postCallEndpoint(url, asientoDTO, CustomResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        AsientoDTO asiento = mapper.convertValue(resMono.block().getData(), AsientoDTO.class);

        return asiento;
    }

    @Override
    public void deshacerSeleccionarAsiento(Long idReserva) {
        String url = Utilidades.formatUrlPost(8082, "/servicio-seleccionar-asiento/asiento");
        Mono<CustomResponse> resMono = restClient.deleteEndpoint(url, idReserva, CustomResponse.class);
        resMono.block();
    }
}
