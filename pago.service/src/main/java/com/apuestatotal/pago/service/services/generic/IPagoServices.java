package com.apuestatotal.pago.service.services.generic;

import com.apuestatotal.pago.service.dto.PagoDTO;

public interface IPagoServices {

    PagoDTO savePago(PagoDTO pago) throws Exception;
    Boolean deletePago(Long id) throws Exception;
}
