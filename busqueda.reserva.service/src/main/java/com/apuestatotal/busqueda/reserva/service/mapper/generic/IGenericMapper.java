package com.apuestatotal.busqueda.reserva.service.mapper.generic;

/**
 * <p>
 * Interfaz generica para mapear los objetos de negocio a los objetos de
 * transferencia de datos.
 * </p>
 * 
 * @author: itocto
 * @since: 2024-03-23
 * @version: 1.0
 */
public interface IGenericMapper<D, B> {

    /**
     * </p>
     * Recibe un objeto de negocio y lo convierte en un objeto de transferencia de
     * datos.
     * </p>
     * 
     * @param bo
     * @return
     */
    public D toDTO(B bo);

    /**
     * </p>
     * Recibe un objeto de transferencia de datos y lo convierte en un objeto de
     * negocio.
     * </p>
     * 
     * @param dto
     * @return
     */
    public B toBO(D dto);
}
