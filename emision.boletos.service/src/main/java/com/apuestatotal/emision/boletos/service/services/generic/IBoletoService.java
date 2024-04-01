package com.apuestatotal.emision.boletos.service.services.generic;

import com.apuestatotal.emision.boletos.service.dto.BoletoDTO;

public interface IBoletoService {

    BoletoDTO saveBoleto(BoletoDTO boleto) throws Exception;

    Boolean deleteBoleto(Long id) throws Exception;
}
