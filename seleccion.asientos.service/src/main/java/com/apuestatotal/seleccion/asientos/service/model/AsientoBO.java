package com.apuestatotal.seleccion.asientos.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asiento")
public class AsientoBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asiento_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private ReservaBO reserva;

    @Column(name = "numero")
    private String numero;

    /**
     * <p>
     * Constructor por defecto {@Link AsientoBO}.
     * </p>
     */
    public AsientoBO() {
    }

    /**
     * <p>
     * Constructor con parametros {@Link AsientoBO}.
     * </p>
     * 
     * @param id
     * @param reserva
     * @param numero
     */
    public AsientoBO(Long id, ReservaBO reserva, String numero) {
        this.id = id;
        this.reserva = reserva;
        this.numero = numero;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "AsientoBO [id=" + id + ", reserva=" + reserva + ", numero=" + numero + "]";
    }

    
}
