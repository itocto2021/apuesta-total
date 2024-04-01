package com.apuestatotal.orquestador.dto;

public class AsientoDTO {
    private Long id;
    private Long reserva;
    private String numero;

    public AsientoDTO() {
    }

    public AsientoDTO(Long id, Long reserva, String numero) {
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

    public Long getReserva() {
        return reserva;
    }

    public void setReserva(Long reserva) {
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
        return "AsientoDTO [id=" + id + ", reserva=" + reserva + ", numero=" + numero + "]";
    }

}
