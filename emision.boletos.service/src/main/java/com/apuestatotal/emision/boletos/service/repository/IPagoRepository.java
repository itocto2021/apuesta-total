package com.apuestatotal.emision.boletos.service.repository;

import com.apuestatotal.emision.boletos.service.model.PagoBO;
import com.apuestatotal.emision.boletos.service.model.ReservaBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagoRepository extends JpaRepository<PagoBO, Long> {

    PagoBO findByReserva(ReservaBO reserva);

}
