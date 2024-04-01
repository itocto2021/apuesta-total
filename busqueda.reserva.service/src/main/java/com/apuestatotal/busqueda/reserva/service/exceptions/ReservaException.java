package com.apuestatotal.busqueda.reserva.service.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

public class ReservaException extends Exception implements Serializable{
    
	/**
	 * 
	 */
    private List<String> errors = new ArrayList<>();
	private static final long serialVersionUID = -2351710654708813771L;
	public static final String DEFAULT_MESSAGE = "Se produjo un error en el service de Reservas. ";
	
    public ReservaException(String message, Throwable cause ) {
        super(message, cause);
    }
    public ReservaException(Set<ConstraintViolation<?>> violationException ) {
        if (!violationException.isEmpty()) {
            violationException.forEach(violation -> {

                Integer start = violation.getPropertyPath().toString().indexOf("[");
                Integer end = violation.getPropertyPath().toString().length();

                String index = violation.getPropertyPath().toString().substring(start,end);

                errors.add(index+ ": " +violation.getMessage());
            });
        } else {
            errors.add("ConstraintViolationException occured.");
        }
        this.errors = errors;
    }
    public ReservaException(String message ) {
        super(message);
    }

    public ReservaException() {

    }

    public List<String> getErrors() {
        return errors;
    }
}
