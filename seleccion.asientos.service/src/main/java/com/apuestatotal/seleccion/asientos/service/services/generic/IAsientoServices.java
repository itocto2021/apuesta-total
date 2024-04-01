package com.apuestatotal.seleccion.asientos.service.services.generic;

import com.apuestatotal.seleccion.asientos.service.dto.AsientoDTO;

public interface IAsientoServices {
    AsientoDTO saveAsiento(AsientoDTO asiento) throws Exception;
    Boolean deleteAsiento(Long id) throws Exception;
}