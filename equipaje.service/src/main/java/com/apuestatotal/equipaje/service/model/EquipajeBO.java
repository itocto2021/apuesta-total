package com.apuestatotal.equipaje.service.model;

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
 * Entidad que representa el equipaje de un pasajero.
 * </p>
 * 
 * @author: itocto
 * @since: 2024-03-23
 * @version: 1.0
 */
@Entity
@Table(name = "equipaje")
public class EquipajeBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipaje_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private ReservaBO reserva;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "peso")
    private double peso;

    /**
     * <p>
     * Constructor por defecto {@Link EquipajeBO}.
     * </p>
     */
    public EquipajeBO() {
    }

    /**
     * <p>
     * Constructor con parametros {@Link EquipajeBO}.
     * </p>
     * 
     * @param id
     * @param reserva
     * @param descripcion
     * @param peso
     */
    public EquipajeBO(Long id, ReservaBO reserva, String descripcion, double peso) {
        this.id = id;
        this.reserva = reserva;
        this.descripcion = descripcion;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReservaBO getReserva() {
        return reserva;
    }

    public void setReserva(ReservaBO reserva) {
        this.reserva = reserva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "EquipajeBO [id=" + id + ", reserva=" + reserva + ", descripcion=" + descripcion + ", peso=" + peso
                + "]";
    }

}
