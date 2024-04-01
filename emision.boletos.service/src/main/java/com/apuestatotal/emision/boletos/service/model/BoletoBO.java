package com.apuestatotal.emision.boletos.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/**
 * <p>
 * Entidad que representa el boleto de una reserva.
 * </p>
 * 
 * @author: itocto
 * @since: 2024-03-23
 * @version: 1.0
 */
@Entity
@Table(name = "boleto")
public class BoletoBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boleto_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "pago_id")
    private PagoBO pago;

    @Column(name = "codigo")
    private String codigo;


    public BoletoBO() {
    }

    public BoletoBO(Long id, PagoBO pago, String codigo) {
        this.id = id;
        this.pago = pago;
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PagoBO getPago() {
        return pago;
    }

    public void setPago(PagoBO pago) {
        this.pago = pago;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
