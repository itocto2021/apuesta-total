package com.apuestatotal.pago.service.repository;

import com.apuestatotal.pago.service.model.ReservaBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apuestatotal.pago.service.model.PagoBO;

@Repository
public interface IPagoRepository extends JpaRepository<PagoBO, Long> {

    PagoBO findByReserva(ReservaBO reserva);
}
