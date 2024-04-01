package com.apuestatotal.orquestador.dto;

/**
 * <p>
 * DTO Ruta para mostrar la informacion de la ruta.
 * </p>
 * 
 * @author: itocto
 * @since: 2024-03-23
 * @version: 1.0
 */
public class RutaDTO {
    private Long rutaId;
    private String origen;
    private String destino;
    private String fecha;

    /**
     * <p>
     * Constructor por defecto {@Link RutaDTO}.
     * </p>
     */
    public RutaDTO() {
    }

    /**
     * <p>
     * Constructor con parametros {@Link RutaDTO}.
     * </p>
     * 
     * @param origen
     * @param destino
     * @param fecha
     * @param rutaId
     */
    public RutaDTO(String origen, String destino, String fecha, Long rutaId) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.rutaId = rutaId;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getRutaId() {
        return rutaId;
    }

    public void setRutaId(Long rutaId) {
        this.rutaId = rutaId;
    }

    @Override
    public String toString() {
        return "RutaDTO [rutaId=" + rutaId + ", origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + "]";
    }

}
