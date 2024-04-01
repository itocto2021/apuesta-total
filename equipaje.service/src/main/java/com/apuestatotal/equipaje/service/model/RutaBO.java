package com.apuestatotal.equipaje.service.model;

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

    /**
     * <p>
     * Constructor por defecto {@Link RutaBO}.
     * </p>
     * 
     * @autor: itocto
     * @since: 2024-03-23
     */
    public RutaBO() {
    }

    /**
     * <p>
     * Constructor con parametros {@Link RutaBO}.
     * </p>
     * 
     * @param id
     * @param origen
     * @param destino
     * @param fecha
     */
    public RutaBO(Long id, String origen, String destino, Date fecha) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "RutaBO [id=" + id + ", origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + "]";
    }
}
