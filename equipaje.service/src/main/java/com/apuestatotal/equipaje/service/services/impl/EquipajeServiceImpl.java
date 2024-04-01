package com.apuestatotal.equipaje.service.services.impl;

import com.apuestatotal.equipaje.service.model.ReservaBO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestatotal.equipaje.service.dto.EquipajeDTO;
import com.apuestatotal.equipaje.service.mapper.impl.EquipajeMapper;
import com.apuestatotal.equipaje.service.model.EquipajeBO;
import com.apuestatotal.equipaje.service.repository.IEquipajeRepository;
import com.apuestatotal.equipaje.service.services.generic.IEquipajeService;

import jakarta.transaction.Transactional;

import java.util.Objects;

@Service
public class EquipajeServiceImpl implements IEquipajeService {

    public static  final Logger logger = LogManager.getLogger(EquipajeServiceImpl.class);
    @Autowired
    private IEquipajeRepository equipajeRepository;

    @Autowired
    private EquipajeMapper equipajeMapper;

    @Transactional
    @Override
    public EquipajeDTO saveEquipaje(EquipajeDTO equipaje) throws Exception {
    logger.info(this.getClass().getSimpleName() + "Ingresando a saveEquipaje");
        EquipajeDTO respDto = null;

        try {
            EquipajeBO bo = equipajeMapper.toBO(equipaje);
            EquipajeBO savedEquipajeBO = equipajeRepository.save(bo);
            respDto = equipajeMapper.toDTO(savedEquipajeBO);

        } catch (Exception e) {
            throw new Exception("Error al guardar el equipaje: " + e.getMessage());
        }

        logger.info(this.getClass().getSimpleName() + "Saliendo de saveEquipaje");
        return respDto;
    }

    @Override
    public Boolean deleteEquipaje(Long id) throws Exception {

        logger.info(this.getClass().getSimpleName() + "Ingresando a deleteEquipaje");
        try {

            ReservaBO reserva = new ReservaBO();
            reserva.setId(id);

            EquipajeBO equipaje = equipajeRepository.findByReserva(reserva);
            if (Objects.nonNull(equipaje)) {
                equipajeRepository.deleteById(equipaje.getId());
            }

            logger.info(this.getClass().getSimpleName() + "Saliendo de deleteEquipaje");
            return true;
        } catch (Exception e) {
            throw new Exception("Error al eliminar el equipaje: " + e.getMessage());
        }
    }

}
