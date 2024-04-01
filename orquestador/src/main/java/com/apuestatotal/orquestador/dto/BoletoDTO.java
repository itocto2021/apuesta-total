package com.apuestatotal.orquestador.dto;

/**
 * <p>
 * Entidad que representa el boleto de una reserva.
 * </p>
 * 
 * @author: itocto
 * @since: 2024-03-23
 * @version: 1.0
 */
public class BoletoDTO {
    private Long id;
    private Long pago;
    private String codigo;

    public BoletoDTO() {
    }

    public BoletoDTO(Long id, Long pago, String codigo) {
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

    public Long getPago() {
        return pago;
    }

    public void setPago(Long pago) {
        this.pago = pago;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "BoletoDTO{" +
                "id=" + id +
                ", pago=" + pago +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
