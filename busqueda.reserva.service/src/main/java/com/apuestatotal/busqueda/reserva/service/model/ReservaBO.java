package com.apuestatotal.busqueda.reserva.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

/**
 * <p>
 * Entidad que representa la reserva de un asiento.
 * </p>
 * 
 * @author: itocto
 * @since: 2024-03-23
 * @version: 1.0
 */
@Entity
@Table(name = "reserva")
public class ReservaBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private RutaBO ruta;

    @Column(name = "cantidad_asientos")
    private int cantidadAsientos;

    @Column(name = "estado")
    private char estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    /**
     * <p>
     * Constructor por defecto {@Link ReservaBO}.
     * </p>
     */
    public ReservaBO() {
    }

    /**
     * <p>
     * Constructor con parametros {@Link ReservaBO}.
     * </p>
     * 
     * @param id
     * @param ruta
     * @param cantidadAsientos
     */
    public ReservaBO(Long id, RutaBO ruta, int cantidadAsientos, char estado, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
        this.id = id;
        this.ruta = ruta;
        this.cantidadAsientos = cantidadAsientos;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RutaBO getRuta() {
        return ruta;
    }

    public void setRuta(RutaBO ruta) {
        this.ruta = ruta;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "ReservaBO{" +
                "id=" + id +
                ", ruta=" + ruta +
                ", cantidadAsientos=" + cantidadAsientos +
                ", estado=" + estado +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }
}
