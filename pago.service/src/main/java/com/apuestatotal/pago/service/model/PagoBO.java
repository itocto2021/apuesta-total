package com.apuestatotal.pago.service.model;

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
 * Entidad que representa el pago de una reserva.
 * </p>
 * 
 * @author: itocto
 * @since: 2024-03-23
 * @version: 1.0
 * 
 */
@Entity
@Table(name = "pago")
public class PagoBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pago_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private ReservaBO reserva;

    @Column(name = "monto")
    private double monto;

    @Column(name = "metodo_pago")
    private String metodoPago;

    /**
     * <p>
     * Constructor por defecto {@Link PagoBO}.
     * </p>
     * 
     */
    public PagoBO() {
    }

    /**
     * <p>
     * Constructor con parametros {@Link PagoBO}.
     * </p>
     * 
     * @param id
     * @param reserva
     * @param monto
     * @param metodoPago
     */
    public PagoBO(Long id, ReservaBO reserva, double monto, String metodoPago) {
        this.id = id;
        this.reserva = reserva;
        this.monto = monto;
        this.metodoPago = metodoPago;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "PagoBO [id=" + id + ", reserva=" + reserva + ", monto=" + monto + ", metodoPago=" + metodoPago + "]";
    }

}
