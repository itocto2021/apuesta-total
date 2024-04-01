package com.apuestatotal.equipaje.service.services.generic;

import com.apuestatotal.equipaje.service.dto.EquipajeDTO;

public interface IEquipajeService {

    EquipajeDTO saveEquipaje(EquipajeDTO equipaje) throws Exception;
    Boolean deleteEquipaje(Long id) throws Exception;
    
}
