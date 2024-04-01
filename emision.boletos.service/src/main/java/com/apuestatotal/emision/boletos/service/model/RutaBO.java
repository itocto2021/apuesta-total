package com.apuestatotal.emision.boletos.service.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * <p>
 * Clase que representa la entidad RutaBO.
 * </p>
 * 
 * @autor: itocto
 * @since: 2024-03-23
 * @version: 1.0
 */
@Entity
@Table(name = "ruta")
public class RutaBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rura_id")
    private Long id;

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha")
    private Date fecha;

}
