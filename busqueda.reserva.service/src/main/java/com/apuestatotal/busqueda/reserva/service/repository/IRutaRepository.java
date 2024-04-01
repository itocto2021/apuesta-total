package com.apuestatotal.busqueda.reserva.service.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apuestatotal.busqueda.reserva.service.model.RutaBO;

@Repository
public interface IRutaRepository extends JpaRepository<RutaBO, Long> {

    List<RutaBO> findByOrigenAndDestinoAndFecha(String origen, String destino, Date fecha);
}
