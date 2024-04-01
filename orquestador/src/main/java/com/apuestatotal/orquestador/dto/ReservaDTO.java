package com.apuestatotal.orquestador.dto;



/**
 * <p>
 * DTOReserva para mostrar la informacion de la reserva.
 * </p>
 * 
 * @author: itocto
 * @since: 2024-03-23
 * @version: 1.0
 */
public class ReservaDTO {

    private Long recervaId;
    private Long ruta;
    private Integer cantidadAsientos;
    private char estado;
    private String fechaCreacion;
    private String fechaModificacion;

    /**
     * <p>
     * Constructor por defecto {@Link ReservaDTO}.
     * </p>
     */
    public ReservaDTO() {
    }

    /**
     * <p>
     * Constructor con parametros {@Link ReservaDTO}.
     * </p>
     *
     * @param recervaId
     * @param ruta
     * @param cantidadAsientos
     */
    public ReservaDTO(Long recervaId, Long ruta, Integer cantidadAsientos, char estado, String fechaCreacion,
                      String fechaModificacion) {
        this.recervaId = recervaId;
        this.ruta = ruta;
        this.cantidadAsientos = cantidadAsientos;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getRuta() {
        return ruta;
    }

    public void setRuta(Long ruta) {
        this.ruta = ruta;
    }

    public Integer getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(Integer cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public Long getRecervaId() {
        return recervaId;
    }

    public void setRecervaId(Long recervaId) {
        this.recervaId = recervaId;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "ReservaDTO{" +
                "recervaId=" + recervaId +
                ", ruta=" + ruta +
                ", cantidadAsientos=" + cantidadAsientos +
                ", estado=" + estado +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

}
