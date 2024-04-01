package com.apuestatotal.orquestador.services.impl.rest;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.apuestatotal.orquestador.controller.generic.CustomResponse;
import com.apuestatotal.orquestador.dto.ReservaDTO;
import com.apuestatotal.orquestador.services.GenericRestClientImpl;
import com.apuestatotal.orquestador.services.generic.rest.IBuscarYReservarRutaService;
import com.apuestatotal.orquestador.utils.Utilidades;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Service
public class BuscarYReservarRutaServiceImpl implements IBuscarYReservarRutaService {
    private final GenericRestClientImpl restClient;

    public BuscarYReservarRutaServiceImpl(GenericRestClientImpl restClient) {
        this.restClient = restClient;
    }

    @Override
    public CustomResponse buscarRuta(String origen, String destino, String fecha) {

        String url = Utilidades.formatUrlGet(9091, origen, destino, fecha);

        Mono<CustomResponse> resMono = restClient.getCallEndpoint(HttpMethod.GET, url, CustomResponse.class);
        return resMono.block();
    }

    @Override
    public ReservaDTO reservarVuelo(ReservaDTO datosCompra) {
        String url = Utilidades.formatUrlPost(9091, "/servicio-reservas/reservas");
        Mono<CustomResponse> resMono = restClient.postCallEndpoint(url, datosCompra, CustomResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        ReservaDTO reserva = mapper.convertValue(resMono.block().getData(), ReservaDTO.class);

        return reserva;
    }

    @Override
    public void confirmarReservaVuelo(Long idReserva) {
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setRecervaId(idReserva);

        String url = Utilidades.formatUrlPost(9091, "/servicio-reservas/reservas");
        Mono<CustomResponse> resMono = restClient.putCallEndpoint(url, reservaDTO, CustomResponse.class);
        resMono.block();
    }

    @Override
    public void deshacerReservarVuelo(Long idReserva) {
        
        String url = Utilidades.formatUrlPost(9091, "/servicio-reservas/reservas");
        Mono<CustomResponse> resMono = restClient.deleteEndpoint(url, idReserva, CustomResponse.class);
        resMono.block();
    }


    

}
