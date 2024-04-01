package com.apuestatotal.orquestador.dto;

public class RequestCompraDTO {
    private ReservaDTO reserva;
    private EquipajeDTO equipaje;
    private AsientoDTO asiento;
    private PagoDTO pago;

    public RequestCompraDTO() {
    }

    public RequestCompraDTO(ReservaDTO reserva, EquipajeDTO equipaje, AsientoDTO asiento, PagoDTO pago) {
        this.reserva = reserva;
        this.equipaje = equipaje;
        this.asiento = asiento;
        this.pago = pago;
    }

    public ReservaDTO getReserva() {
        return reserva;
    }

    public void setReserva(ReservaDTO reserva) {
        this.reserva = reserva;
    }

    public EquipajeDTO getEquipaje() {
        return equipaje;
    }

    public void setEquipaje(EquipajeDTO equipaje) {
        this.equipaje = equipaje;
    }

    public AsientoDTO getAsiento() {
        return asiento;
    }

    public void setAsiento(AsientoDTO asiento) {
        this.asiento = asiento;
    }

    public PagoDTO getPago() {
        return pago;
    }

    public void setPago(PagoDTO pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "RequestCompraDTO [reserva=" + reserva + ", equipaje=" + equipaje + ", asiento=" + asiento + ", pago="
                + pago + "]";
    }

    
}
