package com.apuestatotal.emision.boletos.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

    public ReservaBO() {
    }

    public ReservaBO(Long id, RutaBO ruta, int cantidadAsientos) {
        this.id = id;
        this.ruta = ruta;
        this.cantidadAsientos = cantidadAsientos;
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
}
