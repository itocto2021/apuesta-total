package com.apuestatotal.orquestador.services.impl.rest;

import org.springframework.stereotype.Service;

import com.apuestatotal.orquestador.controller.generic.CustomResponse;
import com.apuestatotal.orquestador.dto.EquipajeDTO;
import com.apuestatotal.orquestador.services.GenericRestClientImpl;
import com.apuestatotal.orquestador.services.generic.rest.IAnadirEquipajeService;
import com.apuestatotal.orquestador.utils.Utilidades;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Service
public class AnadirEquipajeServiceImpl implements IAnadirEquipajeService {
    private final GenericRestClientImpl restClient;

    public AnadirEquipajeServiceImpl(GenericRestClientImpl restClient) {
        this.restClient = restClient;
    }

    @Override
    public EquipajeDTO anadirEquipaje(EquipajeDTO equipajeDTO) {
        String url = Utilidades.formatUrlPost(8086, "/servicio-equipaje/equipaje");
        Mono<CustomResponse> resMono = restClient.postCallEndpoint(url, equipajeDTO, CustomResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        EquipajeDTO reserva = mapper.convertValue(resMono.block().getData(), EquipajeDTO.class);

        return reserva;
    }

    @Override
    public void deshacerAnadirEquipaje(Long idReserva) {
        String url = Utilidades.formatUrlPost(8086, "/servicio-equipaje/equipaje");
        Mono<CustomResponse> resMono = restClient.deleteEndpoint(url, idReserva, CustomResponse.class);
        resMono.block();
    }
}
