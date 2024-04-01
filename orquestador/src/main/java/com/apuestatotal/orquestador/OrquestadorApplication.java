package com.apuestatotal.orquestador;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apuestatotal.orquestador.dto.AsientoDTO;
import com.apuestatotal.orquestador.dto.BoletoDTO;
import com.apuestatotal.orquestador.dto.EquipajeDTO;
import com.apuestatotal.orquestador.dto.PagoDTO;
import com.apuestatotal.orquestador.dto.RequestCompraDTO;
import com.apuestatotal.orquestador.dto.ReservaDTO;
import com.apuestatotal.orquestador.services.generic.IOrquestadorService;

@SpringBootApplication
public class OrquestadorApplication {
	public static final Logger LOGGER = LogManager.getLogger(OrquestadorApplication.class);
	@Autowired
	private IOrquestadorService orquestadorService;

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static void main(String[] args) {
		SpringApplication.run(OrquestadorApplication.class, args);
	}

}
