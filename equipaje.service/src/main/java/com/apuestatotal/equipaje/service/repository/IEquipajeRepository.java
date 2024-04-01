package com.apuestatotal.equipaje.service.repository;

import com.apuestatotal.equipaje.service.model.ReservaBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apuestatotal.equipaje.service.model.EquipajeBO;


@Repository
public interface IEquipajeRepository extends JpaRepository<EquipajeBO, Long>{

    EquipajeBO findByReserva(ReservaBO reserva);
}
