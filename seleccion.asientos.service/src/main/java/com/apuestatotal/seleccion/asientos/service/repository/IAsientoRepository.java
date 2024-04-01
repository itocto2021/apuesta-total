package com.apuestatotal.seleccion.asientos.service.repository;

import com.apuestatotal.seleccion.asientos.service.model.ReservaBO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apuestatotal.seleccion.asientos.service.model.AsientoBO;

public interface IAsientoRepository extends JpaRepository<AsientoBO, Long>{

    AsientoBO findByReserva(ReservaBO reserva);
}
