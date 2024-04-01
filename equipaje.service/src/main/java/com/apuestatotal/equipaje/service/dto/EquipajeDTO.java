package com.apuestatotal.equipaje.service.dto;

public class EquipajeDTO {

    private Long id;
    private Long reserva;
    private String descripcion;
    private double peso;
    
    public EquipajeDTO() {
    }

    public EquipajeDTO(Long id, Long reserva, String descripcion, double peso) {
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

    public Long getReserva() {
        return reserva;
    }

    public void setReserva(Long reserva) {
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
        return "EquipajeDTO [id=" + id + ", reserva=" + reserva + ", descripcion=" + descripcion + ", peso=" + peso
                + "]";
    }

    
}
