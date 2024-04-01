package com.apuestatotal.orquestador.services.generic;

import com.apuestatotal.orquestador.dto.RequestCompraDTO;

public interface IOrquestadorService {
    Boolean realizarCompra(RequestCompraDTO resquest) throws Exception;
}
