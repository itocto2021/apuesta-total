package com.apuestatotal.emision.boletos.service.repository;

import com.apuestatotal.emision.boletos.service.model.PagoBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apuestatotal.emision.boletos.service.model.BoletoBO;

@Repository
public interface IBoletoRepository extends JpaRepository<BoletoBO, Long>{

    BoletoBO findByPago(PagoBO pago);

}
