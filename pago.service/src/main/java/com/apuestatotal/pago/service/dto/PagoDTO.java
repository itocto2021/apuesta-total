package com.apuestatotal.pago.service.dto;

public class PagoDTO {
    private Long id;
    private Long reserva;
    private double monto;
    private String metodoPago;

    public PagoDTO() {
    }

    public PagoDTO(Long id, Long reserva, double monto, String metodoPago) {
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

    public Long getReserva() {
        return reserva;
    }

    public void setReserva(Long reserva) {
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
        return "PagoDTO [id=" + id + ", reserva=" + reserva + ", monto=" + monto + ", metodoPago=" + metodoPago + "]";
    }

}