/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.Especialidad;
import com.cip.cipayacuchopagos.repository.EspecialidadRepository;
import com.cip.cipayacuchopagos.service.EspecialidadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
/**
 *
 * @author Arango
 */
@Service

public class EspecialidadServiceImpl  extends GenericServiceImpl<Especialidad, Integer>  implements EspecialidadService {
    private static final Logger LOGGER = LogManager.getLogger(EspecialidadServiceImpl.class);

    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Override
    public CrudRepository<Especialidad, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("EspecialidadRepository");
        return especialidadRepository;
    }
}
