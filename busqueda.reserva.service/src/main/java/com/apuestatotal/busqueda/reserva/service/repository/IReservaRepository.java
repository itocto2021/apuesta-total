package com.apuestatotal.busqueda.reserva.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apuestatotal.busqueda.reserva.service.model.ReservaBO;

@Repository
public interface IReservaRepository extends JpaRepository<ReservaBO, Long> {

}
